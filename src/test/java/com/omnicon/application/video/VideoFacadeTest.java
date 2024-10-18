package com.omnicon.application.video;

import com.omnicon.application.ai.AiService;
import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.video.VideoCommand;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.infrastructure.conference.ConferenceRepository;
import com.omnicon.infrastructure.speaker.SpeakerRepository;
import com.omnicon.interfaces.search.SearchDto;
import com.omnicon.interfaces.search.SearchType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Transactional
@SpringBootTest
class VideoFacadeTest {

	@Autowired
	private VideoFacade videoFacade;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private SpeakerRepository speakerRepository;

	@MockBean
	private AiService aiService;

	@BeforeEach
	void setUp() {
		// 과금 회피
		given(aiService.summarizeText(anyString(), anyString())).willReturn("영상 내용을 요약했습니다. 테스트 관련 내용입니다.");
		given(aiService.similaritySearch(anyString(), anyInt())).willReturn(List.of(new Document("document")));
	}

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
				.thumbnailUrl("https://thumbnail.url")
				.conferenceToken(conference.getConferenceToken())
				.speakerTokens(List.of(speaker1.getSpeakerToken(), speaker2.getSpeakerToken()))
				.build();

		String videoToken = videoFacade.registerVideo(register);

		Assertions.assertThat(videoToken).isNotBlank();
	}

	@Test
	void 비디오_요약본_검색() {
		// given
		SearchInfo.Request search = SearchInfo.Request.builder()
				.searchType(SearchType.VIDEO_SUMMARY)
				.summary("테스트 관련 내용")
				.limit(10)
				.build();

		// when : 유사도 검색
		List<VideoInfo.Main> videos = videoFacade.searchVideo(search);

		// then
		Assertions.assertThat(videos).hasSizeGreaterThan(0);
	}

	@Test
	void 비디오_리스트_조회() {
	    // given
		SearchInfo.Request search = SearchInfo.Request.builder()
				.limit(10)
				.build();

	    // when
		List<VideoInfo.Main> searchedVideo = videoFacade.searchVideo(search);

		// then
		Assertions.assertThat(searchedVideo).hasSizeGreaterThan(0);
	}


}