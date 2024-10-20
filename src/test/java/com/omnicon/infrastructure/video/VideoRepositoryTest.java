package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.VideoInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class VideoRepositoryTest {

	@Autowired
	private VideoRepository videoRepository;

	@Test
	void findAllByTest() {
	    // given

		// when
		Page<VideoInfo.Main> allBy = videoRepository.findAllBy("닷넷", PageRequest.of(0, 10));

	    // then
		Assertions.assertThat(allBy.getContent()).isNotNull();

	}
}