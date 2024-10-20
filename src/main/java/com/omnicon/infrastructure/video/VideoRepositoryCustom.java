package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.VideoInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoRepositoryCustom {

	Page<VideoInfo.Main> findAllBy(String keyword, Pageable pageable);

}
