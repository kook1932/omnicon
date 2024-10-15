package com.omnicon.interfaces.conference;

import lombok.Data;

import java.time.LocalDate;

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

}
