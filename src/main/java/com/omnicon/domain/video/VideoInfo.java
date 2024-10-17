package com.omnicon.domain.video;

import com.omnicon.interfaces.search.SearchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

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

		public String getYoutubeUrl() {
			return "https://www.youtube.com/watch?v=" + youtubeVideoId;
		}

		// toMap
		public Map<String, Object> toMetadataMap() {
			return new HashMap<>(Map.of(
					"id", id,
					"videoToken", videoToken,
					"youtubeVideoId", youtubeVideoId,
					"title", title,
					"description", description,
					"thumbnailUrl", thumbnailUrl
			));
		}
	}

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Search {
		private SearchType searchType;
		private String title;
		private String summary;
		private int limit;
	}

}
