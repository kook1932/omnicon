package com.omnicon.application.search;

import com.omnicon.domain.video.VideoInfo;

import java.util.List;

public interface SearchService {

	List<VideoInfo.Main> searchSummary(VideoInfo.Search search);

}
