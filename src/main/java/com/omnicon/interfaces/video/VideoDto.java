package com.omnicon.interfaces.video;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class VideoDto {

	@Data
	public static class RegisterRequest {
		private String youtubeVideoId;
		private String title;
		private String description;
		private String thumbnailUrl;
		private LocalDateTime publishedAt;
		private Integer duration;
		private String conferenceToken;
		private List<String> speakerTokens;
	}

	@Data
	public static class SearchRequest {
		private String title;

		@NotBlank
		private String summary;

		private int limit = 5;
	}

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
