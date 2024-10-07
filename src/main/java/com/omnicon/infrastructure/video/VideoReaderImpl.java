package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import com.omnicon.domain.video.VideoReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoReaderImpl implements VideoReader {

	private final VideoRepository videoRepository;

	@Override
	public Video getVideo(String id) {
		return videoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Video not found"))
				.toDomain();
	}

	@Override
	public List<Video> getVideoList() {
		return videoRepository.findAll().stream()
				.map(VideoEntity::toDomain)
				.toList();
	}

}
