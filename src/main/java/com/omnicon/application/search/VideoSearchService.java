package com.omnicon.application.search;

import com.omnicon.application.search.video.VideoFinder;
import com.omnicon.common.exception.InvalidParamException;
import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.interfaces.search.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoSearchService implements SearchService<VideoInfo.Main> {

	private final List<VideoFinder> videoFinderList;

	@Override
	public List<VideoInfo.Main> searchVideo(SearchInfo.Request search) {
		VideoFinder videoFinder = routingFinder(search.getSearchType());
		return videoFinder.findBySearchType(search);
	}

	public VideoFinder routingFinder(SearchType searchType) {
		return videoFinderList.stream()
				.filter(videoFinder -> videoFinder.support(searchType))
				.findFirst()
				.orElseThrow(InvalidParamException::new);
	}

}
