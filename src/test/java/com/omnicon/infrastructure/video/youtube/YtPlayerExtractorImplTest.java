package com.omnicon.infrastructure.video.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Optional;

class YtPlayerExtractorImplTest {

	private YtPlayerExtractorImpl extractor = new YtPlayerExtractorImpl(new ObjectMapper(), new RestTemplateBuilder());

	@DisplayName("ytInitialPlayerResponse json 데이터 read")
	@Test
	void testExtractYtInitialPlayerResponse_Success() {
		// Given: ytInitialPlayerResponse 변수가 포함된 HTML 콘텐츠
		String htmlContent = "<html><head><script></script><script>var ytInitialPlayerResponse = {\"captions\": { \"playerCaptionsTracklistRenderer\": {\"captionTracks\": [{\"baseUrl\": \"https://example.com/captions\", \"isTranslatable\": true}]}}};</script><script></script></head><body></body></html>";

		// When: 메서드를 호출하여 JSON 데이터를 추출
		String jsonData = extractor.extractYtInitialPlayerResponse(htmlContent).get();

		// Then: baseUrl 검증
		Assertions.assertThat(jsonData).contains("\"baseUrl\": \"https://example.com/captions\"");

	}

	@DisplayName("ytInitialPlayerResponse json 데이터가 없는 경우")
	@Test
	void testExtractYtInitialPlayerResponse_NotFound() {
		// Given: ytInitialPlayerResponse 변수가 없는 HTML 콘텐츠
		String htmlContent = "<html><head><script>var someOtherVariable = {};</script></head><body></body></html>";

		// When: 메서드를 호출하여 JSON 데이터를 추출
		Optional<String> jsonData = extractor.extractYtInitialPlayerResponse(htmlContent);

		// Then: JSON 데이터는 null이어야 함
		Assertions.assertThat(jsonData).isNotPresent();
	}


	@DisplayName("json 데이터에서 baseUrl 추출")
	@Test
	void testExtractBaseUrlFromJson_Success() {
		// Given: 올바른 JSON 데이터
		String jsonData = "{\"captions\": { \"playerCaptionsTracklistRenderer\": {\"captionTracks\": [{\"baseUrl\": \"https://example.com/captions\", \"isTranslatable\": true}]}}}";

		// When: 메서드를 호출하여 baseUrl을 추출
		Optional<String> baseUrl = extractor.extractBaseUrlFromYtPlayer(jsonData);

		// Then: baseUrl이 예상된 값이어야 함
		Assertions.assertThat(baseUrl.get()).isEqualTo("https://example.com/captions");
	}

	@DisplayName("captionTrack 정보가 존재하지 않을때")
	@Test
	void testExtractBaseUrlFromJson_InvalidJson() {
		// Given: 잘못된 JSON 데이터
		String jsonData = "{\"captions\": { \"playerCaptionsTracklistRenderer\": {\"captionTracks\": []}}}";

		// When: 메서드를 호출하여 baseUrl을 추출
		Optional<String> baseUrl = extractor.extractBaseUrlFromYtPlayer(jsonData);

		// Then: baseUrl은 null이어야 함
		Assertions.assertThat(baseUrl).isNotPresent();
	}

	@DisplayName("captions 정보가 존재하지 않을때")
	@Test
	void testExtractBaseUrlFromJson_NoCaptions() {
		// Given: captions 필드가 없는 JSON 데이터
		String jsonData = "{\"videoDetails\": {\"title\": \"Example Video\"}}";

		// When: 메서드를 호출하여 baseUrl을 추출
		Optional<String> baseUrl = extractor.extractBaseUrlFromYtPlayer(jsonData);

		// Then: baseUrl은 null이어야 함
		Assertions.assertThat(baseUrl).isNotPresent();
	}

	@DisplayName("HTML 콘텐츠가 있음")
	@Test
	public void testFetchHtmlContent_Success() {
		// Given: 유효한 YouTube 동영상 URL
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI"; // 실제 동영상 ID로 변경

		// When: HTML 콘텐츠를 가져옴
		String htmlContent = extractor.fetchHtmlContent(youtubeUrl).get();

		// Then: HTML 콘텐츠가 있음
		Assertions.assertThat(htmlContent).isNotBlank();
		Assertions.assertThat(htmlContent).contains("ytInitialPlayerResponse");
	}

	@DisplayName("html 요청 -> 추출 -> 파싱")
	@Test
	void fetchHtmlExtractorBaseUrl() {
		// Given: 유효한 YouTube 동영상 URL
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI"; // 실제 동영상 ID로 변경

		// When: HTML 콘텐츠를 가져옴
		Optional<String> htmlContent = extractor.fetchHtmlContent(youtubeUrl);
		Optional<String> html = extractor.extractYtInitialPlayerResponse(htmlContent.get());
		Optional<String> baseUrlFromJson = extractor.extractBaseUrlFromYtPlayer(html.get());

		// Then:UrlParser
		Assertions.assertThat(baseUrlFromJson).isPresent();
	}

	@DisplayName("자막 텍스트 추출 성공")
	@Test
	void extractTranscriptTextTest() {
	    // given
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI";

		// When: HTML 콘텐츠를 가져옴
		Optional<String> htmlContent = extractor.fetchHtmlContent(youtubeUrl);
		Optional<String> html = extractor.extractYtInitialPlayerResponse(htmlContent.get());
		Optional<String> baseUrlFromJson = extractor.extractBaseUrlFromYtPlayer(html.get());
		Optional<String> transcriptText = extractor.extractTranscriptText(baseUrlFromJson.get());

		// Then:UrlParser
		Assertions.assertThat(transcriptText).isPresent();
	}
}