package com.omnicon.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenAiService implements AiService {

	private static final String summaryPromptTemplate = """
			The following text is a subtitle script for a YouTube video presented at a developer conference.
			Please analyze the script and summarize the content in Korean. : %s
			""";

	private final OpenAiChatModel chatModel;

	@Override
	public String summarizeText(String text) {
		String prompt = String.format(summaryPromptTemplate, text);
		return chatModel.call(prompt);
	}

}
