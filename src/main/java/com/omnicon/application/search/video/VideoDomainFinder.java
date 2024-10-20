package com.omnicon.application.search.video;

import com.omnicon.domain.video.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
