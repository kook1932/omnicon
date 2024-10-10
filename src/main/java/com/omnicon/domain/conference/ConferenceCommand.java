package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ConferenceCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Register {
		private String hostToken;
		private String name;
		private String description;
		private LocalDate startDate;
		private LocalDate endDate;
		private String location;
		private String websiteUrl;

		public Conference toEntity(Host host) {
			return Conference.builder()
					.name(name)
					.description(description)
					.startDate(startDate)
					.endDate(endDate)
					.location(location)
					.websiteUrl(websiteUrl)
					.host(host)
					.build();
		}
	}

}
