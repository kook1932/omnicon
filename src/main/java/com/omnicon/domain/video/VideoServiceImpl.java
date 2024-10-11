package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.conference.ConferenceReader;
import com.omnicon.domain.speaker.SpeakerReader;
import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoServiceImpl implements VideoService {

	private final ConferenceReader conferenceReader;
	private final SpeakerReader speakerReader;
	private final VideoStore videoStore;
	private final VideoInfoMapper videoInfoMapper;

	@Transactional
	@Override
	public VideoInfo.Main registerVideo(VideoCommand.Register register) {
		Conference conference = conferenceReader.getConferenceBy(register.getConferenceToken());
		Video video = videoStore.save(register.toEntity(conference));

		List<VideoSpeaker> videoSpeakers = speakerReader.getAllSpeakers(register.getSpeakerTokens()).stream()
				.map(speaker ->
						VideoSpeaker.builder()
								.video(video)
								.speaker(speaker)
								.build()
				)
				.toList();

		video.getVideoSpeakers().addAll(
				videoStore.saveAll(videoSpeakers)
		);

		return videoInfoMapper.from(video);
	}
}
