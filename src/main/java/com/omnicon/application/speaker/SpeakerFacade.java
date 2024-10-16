package com.omnicon.application.speaker;

import com.omnicon.domain.speaker.SpeakerCommand;
import com.omnicon.domain.speaker.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpeakerFacade {

	private final SpeakerService speakerService;

	public String registerSpeaker(SpeakerCommand.Register register) {
		return speakerService.registerSpeaker(register).getSpeakerToken();
	}

}
