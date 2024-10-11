package com.omnicon.domain.video;

import com.omnicon.domain.video.videospeaker.VideoSpeaker;

import java.util.List;

public interface VideoStore {

	Video save(Video video);
	List<VideoSpeaker> saveAll(List<VideoSpeaker> videoSpeakerList);

}
