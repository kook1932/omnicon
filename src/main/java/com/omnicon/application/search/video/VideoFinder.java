package com.omnicon.application.search.video;

import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.interfaces.search.SearchType;

import java.util.List;

public interface VideoFinder {

	List<VideoInfo.Main> findBySearchType(SearchInfo.Request search);

	boolean support(SearchType searchType);

}
