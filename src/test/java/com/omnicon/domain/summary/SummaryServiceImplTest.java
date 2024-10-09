package com.omnicon.domain.summary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SummaryServiceImplTest {

	@Autowired
	private SummaryService summaryServiceImpl;

	@Test
	void summarizeVideoTest() {
		String youtubeUrl = "https://www.youtube.com/watch?v=pCE7ibRCZEI";

		// When: SUMMARY
		String summary = summaryServiceImpl.summarizeVideo(youtubeUrl);

		// Then: SUMMARY
		System.out.println("summary = " + summary);
		Assertions.assertThat(summary).isNotBlank();
	}

}