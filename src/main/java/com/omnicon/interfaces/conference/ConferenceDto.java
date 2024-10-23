package com.omnicon.interfaces.conference;

import com.omnicon.domain.host.HostInfo;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.interfaces.host.HostDto;
import com.omnicon.interfaces.video.VideoDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConferenceDto {

	@Data
	public static class RegisterRequest {
		private String hostToken;
		private String name;
		private String description;
		private LocalDate startDate;
		private LocalDate endDate;
		private String location;
		private String websiteUrl;
	}

	@Data
	public static class Main {
		private String conferenceToken;
		private String name;
		private String description;

		private LocalDate startDate;
		private LocalDate endDate;
		private String location;
		private String websiteUrl;

		private HostDto.Main host;
		private List<VideoDto.Main> videos = new ArrayList<>();
	}
}
