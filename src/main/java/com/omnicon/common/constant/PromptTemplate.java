package com.omnicon.common.constant;

public class PromptTemplate {

	// script 요약 프롬프트
	public static final String SUMMARY_PROMPT_TEMPLATE = """
			The text below is a subtitle script from a YouTube video presented at a developer conference.
			Please analyze this script and write a structured summary in Korean, including main themes, key points, details, and conclusion.
			: %s
			""";

}
