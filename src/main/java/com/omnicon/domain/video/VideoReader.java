package com.omnicon.domain.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoReader {

	Video findBy(String videoToken);

	Page<VideoInfo.Main> findAllBy(VideoInfo.Retrieve retrieve, Pageable pageable);

}
