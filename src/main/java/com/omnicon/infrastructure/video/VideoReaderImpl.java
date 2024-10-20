package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.domain.video.VideoReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VideoReaderImpl implements VideoReader {

	private final VideoRepository videoRepository;

	@Override
	public Video findBy(String videoToken) {
		return videoRepository.findByVideoToken(videoToken)
				.orElseThrow(() -> new IllegalArgumentException("Video not found"));
	}

	@Override
	public Page<VideoInfo.Main> findAllBy(VideoInfo.Retrieve retrieve, Pageable pageable) {
		return videoRepository.findAllBy(retrieve.getKeyword(), pageable);
	}

}
