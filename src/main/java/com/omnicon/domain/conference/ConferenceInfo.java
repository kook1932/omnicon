package com.omnicon.domain.conference;

import com.omnicon.domain.host.HostInfo;
import com.omnicon.domain.video.VideoInfo;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConferenceInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter @Setter
	public static class Main {
		private String conferenceToken;
		private String name;
		private String description;

		private LocalDate startDate;
		private LocalDate endDate;
		private String location;
		private String websiteUrl;

		private HostInfo.Main host;
		private List<VideoInfo.Main> videos = new ArrayList<>();
	}

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter @Setter
	public static class Retrieve {
		private String keyword;
	}
}
