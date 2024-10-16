package com.omnicon.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicon.application.ai.AiService;
import com.omnicon.domain.video.VideoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SearchServiceImpl implements SearchService {

	private final AiService aiService;
	private final ObjectMapper objectMapper;

	@Override
	public List<VideoInfo.Main> searchSummary(VideoInfo.Search search) {
		return aiService.similaritySearch(search.getSummary(), search.getLimit())
				.stream()
				.map(document -> objectMapper.convertValue(document.getMetadata(), VideoInfo.Main.class))
				.toList();
	}
}
