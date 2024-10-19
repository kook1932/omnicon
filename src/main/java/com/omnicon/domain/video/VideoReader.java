package com.omnicon.domain.video;

import com.omnicon.domain.common.SearchInfo;

import java.util.List;

public interface VideoReader {

	Video getVideo(String id);

	List<VideoInfo.Main> findAllBy(VideoInfo.Retrieve retrieve);

}
