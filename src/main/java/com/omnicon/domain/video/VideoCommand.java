package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class VideoCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter @Setter
	public static class Register {
		private String youtubeVideoId;
		private String title;
		private String description;
		private String thumbnailUrl;
		private LocalDateTime publishedAt;
		private String summary;
		private String conferenceToken;
		private List<String> speakerTokens;

		public Video toEntity(Conference conference) {
			Video video = Video.builder()
					.youtubeVideoId(youtubeVideoId)
					.title(title)
					.description(description)
					.thumbnailUrl(thumbnailUrl)
					.publishedAt(publishedAt)
					.summary(summary)
					.build();

			video.setConference(conference);
			return video;
		}

		public String getYoutubeUrl() {
			return "https://www.youtube.com/watch?v=" + youtubeVideoId;
		}

	}

}
