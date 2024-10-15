package com.omnicon.application.service;

import com.omnicon.domain.video.VideoInfo;

import java.util.List;

public interface SearchService {

	List<VideoInfo.Main> searchSummary(VideoInfo.Search search);

}
