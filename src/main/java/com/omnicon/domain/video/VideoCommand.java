package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class VideoCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Register {
		private String youtubeVideoId;
		private String title;
		private String description;
		private String thumbnailUrl;
		private LocalDateTime publishedAt;
		private Integer duration;
		private String conferenceToken;
		private List<String> speakerTokens;

		public Video toEntity(Conference conference) {
			Video video = Video.builder()
					.youtubeVideoId(youtubeVideoId)
					.title(title)
					.description(description)
					.thumbnailUrl(thumbnailUrl)
					.publishedAt(publishedAt)
					.duration(duration)
					.build();

			video.setConference(conference);
			return video;
		}

	}

}
