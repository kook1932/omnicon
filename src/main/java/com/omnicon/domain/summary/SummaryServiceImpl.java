package com.omnicon.domain.summary;

import com.omnicon.application.service.AiService;
import com.omnicon.domain.video.youtube.YtPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummaryServiceImpl implements SummaryService {

	private final YtPlayerService ytPlayerService;
	private final AiService aiService;

	@Override
	public String summarizeVideo(String youtubeUrl) {
		String transcriptText = ytPlayerService.getTranscriptText(youtubeUrl);
		return aiService.summarizeText(transcriptText);
	}

}
