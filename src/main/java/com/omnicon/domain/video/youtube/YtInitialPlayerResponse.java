package com.omnicon.domain.video.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class YtInitialPlayerResponse {
	private Captions captions;

	@Data
	public static class Captions {
		private PlayerCaptionsTracklistRenderer playerCaptionsTracklistRenderer;
	}

	@Data
	public static class PlayerCaptionsTracklistRenderer {
		private List<CaptionTrack> captionTracks;
	}

	@Data
	public static class CaptionTrack {
		private String baseUrl;

		@JsonProperty("isTranslatable")
		private boolean isTranslatable;
	}
}
