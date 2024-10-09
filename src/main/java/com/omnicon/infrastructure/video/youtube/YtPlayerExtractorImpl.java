package com.omnicon.infrastructure.video.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicon.domain.video.youtube.YtInitialPlayerResponse;
import com.omnicon.domain.video.youtube.YtPlayerExtractor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.omnicon.domain.video.youtube.YtInitialPlayerResponse.*;

@Slf4j
@Component
public class YtPlayerExtractorImpl implements YtPlayerExtractor {

	private final ObjectMapper objectMapper;
	private final RestTemplate restTemplate;

	public YtPlayerExtractorImpl(ObjectMapper objectMapper, RestTemplateBuilder builder) {
		this.objectMapper = objectMapper;
		this.restTemplate = builder.build();
	}

	@Override
	public Optional<String> extractYtInitialPlayerResponse(String htmlContent) {
		// Jsoup을 사용하여 HTML 파싱
		Document doc = Jsoup.parse(htmlContent);

		// 모든 <script> 태그 선택
		Elements scriptElements = doc.getElementsByTag("script");

		// 각 <script> 태그를 순회하며 검사
		for (Element scriptElement : scriptElements) {
			String scriptContent = scriptElement.html();

			// 'var ytInitialPlayerResponse =' 문자열이 포함되어 있는지 확인
			int index = scriptContent.indexOf("var ytInitialPlayerResponse =");
			if (index != -1) {
				// 변수 할당 부분부터 문자열 추출 시작
				int startIndex = index + "var ytInitialPlayerResponse =".length();

				// 중괄호 매칭을 통해 JSON 데이터의 끝 위치 찾기
				int braceCount = 0;
				int endIndex = -1;
				for (int i = startIndex; i < scriptContent.length(); i++) {
					char c = scriptContent.charAt(i);
					if (c == '{') {
						braceCount++;
					} else if (c == '}') {
						braceCount--;
						if (braceCount == 0) {
							endIndex = i + 1;
							break;
						}
					}
				}

				// JSON 데이터 추출 및 반환
				if (endIndex != -1) {
					String jsonData = scriptContent.substring(startIndex, endIndex).trim();
					return Optional.of(jsonData);
				}
			}
		}
		// 해당 변수가 없을 경우 null 반환 또는 예외 처리
		return Optional.empty();
	}

	@Override
	public Optional<String> extractBaseUrlFromJson(String jsonData) {
		try {
			// JSON 데이터를 POJO 객체로 매핑
			YtInitialPlayerResponse response = objectMapper.readValue(jsonData, YtInitialPlayerResponse.class);

			// baseUrl 추출
			Captions captions = response.getCaptions();
			if (captions != null) {
				PlayerCaptionsTracklistRenderer renderer = captions.getPlayerCaptionsTracklistRenderer();
				if (renderer != null) {
					List<CaptionTrack> captionTracks = renderer.getCaptionTracks();
					if (!CollectionUtils.isEmpty(captionTracks)) {
						return Optional.ofNullable(captionTracks.get(0).getBaseUrl());
					}
				}
			}
		} catch (IOException e) {
			log.error("Error parsing JSON data", e);
		}

		// baseUrl을 찾을 수 없을 경우 null 반환
		return Optional.empty();
	}

	@Override
	public Optional<String> fetchHtmlContent(String youtubeUrl) {
		// HTTP 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Mozilla/5.0");

		// HTTP 엔티티 생성
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// HTTP GET 요청
		ResponseEntity<String> response = restTemplate.exchange(
				youtubeUrl,
				HttpMethod.GET,
				entity,
				String.class
		);

		// 응답 코드 확인
		if (response.getStatusCode().is2xxSuccessful()) {
			return Optional.ofNullable(response.getBody());
		} else {
			throw new RuntimeException("Failed to fetch HTML content from YouTube URL: " + youtubeUrl);
		}
	}
}
