package com.omnicon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenAiService implements AiService {

	private static final String SUMMARY_PROMPT_TEMPLATE = """
			The text below is a subtitle script from a YouTube video presented at a developer conference.
			Please analyze this script and write a structured summary in Korean, including main themes, key points, details, and conclusion.
			: %s
			""";

	private final OpenAiChatModel chatModel;

	@Override
	public String summarizeText(String text) {
		String prompt = String.format(SUMMARY_PROMPT_TEMPLATE, text);
		return chatModel.call(prompt);
	}

}
