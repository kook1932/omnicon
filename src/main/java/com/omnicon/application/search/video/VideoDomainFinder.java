package com.omnicon.application.search.video;

import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.domain.video.VideoService;
import com.omnicon.interfaces.search.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoDomainFinder {

	private final VideoService videoService;

//	@Override
//	public List<VideoInfo.Main> findBySearchType(SearchInfo.Request search) {
//		return videoService.getTop10Videos();
//	}

//	@Override
//	public boolean support(SearchType searchType) {
//		return searchType == null || searchType == SearchType.VIDEO_TITLE;
//	}

}
