package com.omnicon.application.search.video;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicon.application.ai.AiService;
import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.interfaces.search.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoSummaryFinder implements VideoFinder {

	private final AiService aiService;
	private final ObjectMapper objectMapper;

	@Override
	public List<VideoInfo.Main> findBySearchType(SearchInfo.Request search) {
		return aiService.similaritySearch(search.getSummary(), search.getLimit())
				.stream()
				.map(document -> objectMapper.convertValue(document.getMetadata(), VideoInfo.Main.class))
				.toList();
	}

	@Override
	public boolean support(SearchType searchType) {
		return searchType == SearchType.VIDEO_SUMMARY;
	}
}
