package com.omnicon.application.summary;

import com.omnicon.interfaces.ai.AiService;
import com.omnicon.common.constant.PromptTemplate;
import com.omnicon.domain.video.youtube.YtPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummarizerImpl implements Summarizer {

	private final YtPlayerService ytPlayerService;
	private final AiService aiService;

	@Override
	public String summarizeVideo(String youtubeUrl) {
		String transcriptText = ytPlayerService.getTranscriptText(youtubeUrl);
		return aiService.summarizeText(transcriptText, PromptTemplate.SUMMARY_PROMPT_TEMPLATE);
	}

}
