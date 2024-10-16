package com.omnicon.domain.speaker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SpeakerCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Register {
		private String name;

		public Speaker toEntity() {
			return Speaker.builder()
					.name(name)
					.build();
		}
	}

}
