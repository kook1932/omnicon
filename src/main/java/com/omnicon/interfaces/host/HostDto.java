package com.omnicon.interfaces.host;

import lombok.Data;

public class HostDto {

	@Data
	public static class RegisterRequest {
		private String name;
		private String description;
		private String websiteUrl;
		private String logoUrl;
	}

}
