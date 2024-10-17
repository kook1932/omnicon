package com.omnicon.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicon.application.ai.AiService;
import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.video.VideoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoSearchService implements SearchService<VideoInfo.Main> {

	private final AiService aiService;
	private final ObjectMapper objectMapper;

	@Override
	public List<VideoInfo.Main> searchVideo(SearchInfo.Request search) {
		return aiService.similaritySearch(search.getSummary(), search.getLimit())
				.stream()
				.map(document -> objectMapper.convertValue(document.getMetadata(), VideoInfo.Main.class))
				.toList();
	}

}
