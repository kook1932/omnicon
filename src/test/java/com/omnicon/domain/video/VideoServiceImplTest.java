package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.conference.ConferenceReader;
import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.speaker.SpeakerReader;
import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VideoServiceImplTest {

	@Mock
	private ConferenceReader conferenceReader;

	@Mock
	private SpeakerReader speakerReader;

	@Mock
	private VideoStore videoStore;

	@Mock
	private VideoInfoMapper videoInfoMapper;

	@InjectMocks
	private VideoServiceImpl videoServiceImpl;

	@Test
	void Video_저장테스트_성공() {
		// Given
		// 1. 입력 데이터 설정
		VideoCommand.Register register = VideoCommand.Register.builder()
				.youtubeVideoId("yt1234")
				.title("title")
				.description("description")
				.conferenceToken("conferenceToken")
				.speakerTokens(List.of("speakerToken1", "speakerToken2"))
				.build();

		// 2. Mock 객체의 동작 정의
		Conference conference = Conference.builder()
				.name("conference")
				.build();
		when(conferenceReader.getConferenceBy("conferenceToken")).thenReturn(conference);

		Video video = Video.builder().youtubeVideoId("yt1234").build();
		when(videoStore.save(any(Video.class))).thenReturn(video);

		Speaker speaker1 = new Speaker();
		Speaker speaker2 = new Speaker();
		when(speakerReader.getAllSpeakers(register.getSpeakerTokens())).thenReturn(List.of(speaker1, speaker2));

		VideoSpeaker videoSpeaker1 = VideoSpeaker.builder().video(video).speaker(speaker1).build();
		VideoSpeaker videoSpeaker2 = VideoSpeaker.builder().video(video).speaker(speaker2).build();
		List<VideoSpeaker> videoSpeakers = List.of(videoSpeaker1, videoSpeaker2);
		when(videoStore.saveAll(anyList())).thenReturn(videoSpeakers);

		VideoInfo.Main videoInfo = VideoInfo.Main.builder()
				.videoToken(video.getVideoToken())
				.youtubeVideoId(video.getYoutubeVideoId())
				.build();
		when(videoInfoMapper.from(video)).thenReturn(videoInfo);

		// When: 테스트 대상 메소드를 실행합니다.
		VideoInfo.Main result = videoServiceImpl.registerVideo(register);

		// Then: 결과를 검증합니다.
		Assertions.assertThat(result.getYoutubeVideoId()).isEqualTo("yt1234");
		Assertions.assertThat(result.getVideoToken()).isNotBlank();
	}

}