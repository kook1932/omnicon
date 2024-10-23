package com.omnicon.domain.host;

import com.omnicon.domain.conference.ConferenceInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class HostInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Main {
		private String hostToken;
		private String name;
		private String description;
		private String websiteUrl;
		private String logoUrl;

		private List<ConferenceInfo.Main> conferences;
	}

}
