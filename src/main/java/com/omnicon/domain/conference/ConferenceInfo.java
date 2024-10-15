package com.omnicon.domain.conference;

import com.omnicon.domain.host.HostInfo;
import com.omnicon.domain.video.VideoInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConferenceInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Main {
		private Long id;
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

}
