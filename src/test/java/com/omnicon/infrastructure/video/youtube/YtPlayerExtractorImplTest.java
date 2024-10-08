package com.omnicon.infrastructure.video.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class YtPlayerExtractorImplTest {

	private YtPlayerExtractorImpl extractor = new YtPlayerExtractorImpl(new ObjectMapper());

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
		Optional<String> baseUrl = extractor.extractBaseUrlFromJson(jsonData);

		// Then: baseUrl이 예상된 값이어야 함
		Assertions.assertThat(baseUrl.get()).isEqualTo("https://example.com/captions");
	}

	@DisplayName("captionTrack 정보가 존재하지 않을때")
	@Test
	void testExtractBaseUrlFromJson_InvalidJson() {
		// Given: 잘못된 JSON 데이터
		String jsonData = "{\"captions\": { \"playerCaptionsTracklistRenderer\": {\"captionTracks\": []}}}";

		// When: 메서드를 호출하여 baseUrl을 추출
		Optional<String> baseUrl = extractor.extractBaseUrlFromJson(jsonData);

		// Then: baseUrl은 null이어야 함
		Assertions.assertThat(baseUrl).isNotPresent();
	}

	@DisplayName("captions 정보가 존재하지 않을때")
	@Test
	void testExtractBaseUrlFromJson_NoCaptions() {
		// Given: captions 필드가 없는 JSON 데이터
		String jsonData = "{\"videoDetails\": {\"title\": \"Example Video\"}}";

		// When: 메서드를 호출하여 baseUrl을 추출
		Optional<String> baseUrl = extractor.extractBaseUrlFromJson(jsonData);

		// Then: baseUrl은 null이어야 함
		Assertions.assertThat(baseUrl).isNotPresent();
	}
}