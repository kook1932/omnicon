package com.omnicon.domain.video.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class YtInitialPlayerResponse {
	private Captions captions;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	public static class Captions {
		private PlayerCaptionsTracklistRenderer playerCaptionsTracklistRenderer;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	public static class PlayerCaptionsTracklistRenderer {
		private List<CaptionTrack> captionTracks;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Data
	public static class CaptionTrack {
		private String baseUrl;

		@JsonProperty("isTranslatable")
		private boolean isTranslatable;
	}
}
