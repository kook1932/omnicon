package com.omnicon.interfaces.host;

import com.omnicon.domain.conference.ConferenceInfo;
import com.omnicon.interfaces.conference.ConferenceDto;
import lombok.Data;

import java.util.List;

public class HostDto {

	@Data
	public static class RegisterRequest {
		private String name;
		private String description;
		private String websiteUrl;
		private String logoUrl;
	}

	@Data
	public static class Main {
		private String hostToken;
		private String name;
		private String description;
		private String websiteUrl;
		private String logoUrl;

		private List<ConferenceDto.Main> conferences;
	}

}
