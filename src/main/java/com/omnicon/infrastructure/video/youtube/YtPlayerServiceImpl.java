package com.omnicon.infrastructure.video.youtube;

import com.omnicon.domain.video.youtube.YtPlayerExtractor;
import com.omnicon.domain.video.youtube.YtPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YtPlayerServiceImpl implements YtPlayerService {

	private final YtPlayerExtractor ytPlayerExtractorImpl;
	@Override
	public String getTranscriptText(String youtubeUrl) {
		String htmlContent = fetchHtmlContent(youtubeUrl);
		String ytInitialPlayerResponse = extractYtInitialPlayerResponse(htmlContent);
		String baseUrl = extractBaseUrlFromYtPlayer(ytInitialPlayerResponse);
		return extractTranscriptText(baseUrl);
	}

	private String fetchHtmlContent(String youtubeUrl) {
		return ytPlayerExtractorImpl.fetchHtmlContent(youtubeUrl)
				.orElseThrow(() -> new IllegalArgumentException("Failed to fetch HTML content from YouTube URL: " + youtubeUrl));
	}

	private String extractYtInitialPlayerResponse(String htmlContent) {
		return ytPlayerExtractorImpl.extractYtInitialPlayerResponse(htmlContent)
				.orElseThrow(() -> new IllegalArgumentException("Failed to extract ytInitialPlayerResponse from HTML content: " + htmlContent));
	}

	private String extractBaseUrlFromYtPlayer(String ytInitialPlayerResponse) {
		return ytPlayerExtractorImpl.extractBaseUrlFromYtPlayer(ytInitialPlayerResponse)
				.orElseThrow(() -> new IllegalArgumentException("Failed to extract base URL from ytInitialPlayerResponse: " + ytInitialPlayerResponse));
	}

	private String extractTranscriptText(String baseUrl) {
		return ytPlayerExtractorImpl.extractTranscriptText(baseUrl)
				.orElseThrow(() -> new IllegalArgumentException("Failed to extract transcript text from base URL: " + baseUrl));
	}

}