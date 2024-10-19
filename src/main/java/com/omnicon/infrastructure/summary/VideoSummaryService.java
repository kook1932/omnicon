package com.omnicon.infrastructure.summary;

import com.omnicon.domain.common.DomainType;
import com.omnicon.domain.summary.Summary;
import com.omnicon.domain.summary.SummaryService;
import com.omnicon.domain.video.VideoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoSummaryService implements SummaryService {

	private final VectorStore vectorStore;

	@Override
	public Summary storeSummary(VideoInfo.Main video) {
		Summary summary = Summary.builder()
				.domainToken(video.getVideoToken())
				.domainType(DomainType.VIDEO)
				.domainMetaData(video.toMetadataMap())
				.build();

		vectorStore.add(List.of(summary.toDocument()));
		return summary;
	}

}
