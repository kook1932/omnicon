package com.omnicon.infrastructure.summary;

import com.omnicon.application.service.Summarizer;
import com.omnicon.domain.summary.Summary;
import com.omnicon.domain.summary.SummaryService;
import com.omnicon.domain.video.VideoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SummaryServiceImpl implements SummaryService {

	private final Summarizer summarizer;
	private final VectorStore vectorStore;

	@Override
	public Summary storeSummary(VideoInfo.Main video) {
		String summarizedVideo = summarizer.summarizeVideo(video.getYoutubeUrl());
		System.out.println("summarizedVideo = " + summarizedVideo);
		Summary summary = Summary.builder()
				.videoToken(video.getVideoToken())
				.summaryText(summarizedVideo)
				.video(video)
				.build();

		vectorStore.add(List.of(summary.toDocument()));
		return summary;
	}

}
