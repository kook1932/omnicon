package com.omnicon.domain.video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class VideoInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Main {
		private String id;
		private String videoToken;
		private String youtubeVideoId;
		private String title;
		private String description;
		private String thumbnailUrl;
	}

}
