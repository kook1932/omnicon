package com.omnicon.domain.host;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HostCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Register {
		private String name;
		private String description;
		private String websiteUrl;
		private String logoUrl;

		public Host toEntity() {
			return Host.builder()
				.name(name)
				.description(description)
				.websiteUrl(websiteUrl)
				.logoUrl(logoUrl)
				.build();
		}
	}

}
