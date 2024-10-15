package com.omnicon.domain.summary;

import com.omnicon.application.service.ai.AiService;
import com.omnicon.application.service.Summarizer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class SummarizerImplTest {

	@Autowired
	private Summarizer summarizerImpl;

	@MockBean
	private AiService aiService;

	@BeforeEach
	void setUp() {
		// 과금 회피
		given(aiService.summarizeText(anyString(), anyString())).willReturn("영상 내용을 요약했습니다. 테스트 관련 내용입니다.");
	}

	@Test
	void summarizeVideoTest() {
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI";

		// When: SUMMARY
		String summary = summarizerImpl.summarizeVideo(youtubeUrl);

		// Then: SUMMARY
		System.out.println("summary = " + summary);
		Assertions.assertThat(summary).isNotBlank();
	}

}