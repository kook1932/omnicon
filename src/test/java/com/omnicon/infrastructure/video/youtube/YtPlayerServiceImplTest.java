package com.omnicon.infrastructure.video.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicon.domain.video.youtube.YtPlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.junit.jupiter.api.Assertions.*;

class YtPlayerServiceImplTest {

	private final YtPlayerService ytPlayerService = new YtPlayerServiceImpl(
			new YtPlayerExtractorImpl(new ObjectMapper(), new RestTemplateBuilder())
	);

	@Test
	void getTranscriptTextTest() {
		// Given: 유효한 YouTube 동영상 URL
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI";

		// When: HTML 콘텐츠를 가져옴
		String htmlContent = ytPlayerService.getTranscriptText(youtubeUrl);

		// Then: transcript text
		System.out.println("htmlContent = " + htmlContent);
		Assertions.assertThat(htmlContent).isNotBlank();
	}
}