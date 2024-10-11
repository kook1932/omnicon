package com.omnicon.domain.summary;

import com.omnicon.application.service.Summarizer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SummarizerImplTest {

	@Autowired
	private Summarizer summarizerImpl;

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