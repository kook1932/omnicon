package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import com.omnicon.domain.video.VideoInfo;
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
				.orElseThrow(() -> new IllegalArgumentException("Video not found"));
	}

	@Override
	public List<VideoInfo.Main> findAllBy(VideoInfo.Retrieve retrieve) {
		return List.of();
	}

}
