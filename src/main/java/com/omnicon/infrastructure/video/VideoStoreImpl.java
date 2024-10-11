package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import com.omnicon.domain.video.VideoStore;
import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import com.omnicon.infrastructure.video.videospeaker.VideoSpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoStoreImpl implements VideoStore {

	private final VideoRepository videoRepository;
	private final VideoSpeakerRepository videoSpeakerRepository;

	@Override
	public Video save(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public List<VideoSpeaker> saveAll(List<VideoSpeaker> videoSpeakerList) {
		return videoSpeakerRepository.saveAll(videoSpeakerList);
	}

}
