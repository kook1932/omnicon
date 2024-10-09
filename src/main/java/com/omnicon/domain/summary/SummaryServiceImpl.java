package com.omnicon.domain.summary;

import com.omnicon.application.service.AiService;
import com.omnicon.domain.video.youtube.YtPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummaryServiceImpl implements SummaryService {

	private final YtPlayerService ytPlayerServiceImpl;
	private final AiService openAiService;

	@Override
	public String summarizeVideo(String youtubeUrl) {
		String transcriptText = ytPlayerServiceImpl.getTranscriptText(youtubeUrl);
		return openAiService.summarizeText(transcriptText);
	}

}
