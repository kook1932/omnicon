package com.omnicon.application.facade;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.video.VideoCommand;
import com.omnicon.infrastructure.conference.ConferenceRepository;
import com.omnicon.infrastructure.speaker.SpeakerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class VideoFacadeTest {

	@Autowired
	private VideoFacade videoFacade;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private SpeakerRepository speakerRepository;

	@Test
	void 비디오내용과_요약본_vector를_저장한다() {
		Conference conference = conferenceRepository.save(
				Conference.builder()
						.name("테스트 컨퍼런스")
						.build()
		);

		var speaker1 = speakerRepository.save(
				Speaker.builder()
						.name("speaker1")
						.build()
		);
		var speaker2 = speakerRepository.save(
				Speaker.builder()
						.name("speaker2")
						.build()
		);

		var register = VideoCommand.Register.builder()
				.youtubeVideoId("pCE7ibRCZEI")
				.title("저장 테스트")
				.description("설명")
				.conferenceToken(conference.getConferenceToken())
				.speakerTokens(List.of(speaker1.getSpeakerToken(), speaker2.getSpeakerToken()))
				.build();

		String videoToken = videoFacade.registerVideo(register);

		Assertions.assertThat(videoToken).isNotBlank();

	}

}