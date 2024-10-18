package com.omnicon.interfaces.video;

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

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Main {
		private String videoToken;
		private String youtubeVideoId;
		private String title;
		private String description;
		private String thumbnailUrl;
	}

}
