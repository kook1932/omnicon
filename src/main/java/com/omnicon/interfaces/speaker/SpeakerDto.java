package com.omnicon.interfaces.speaker;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class SpeakerDto {

	@Data
	public static class RegisterRequest {
		@NotBlank
		private String name;
	}

}
