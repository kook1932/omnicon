package com.omnicon.application.conference;

import com.omnicon.domain.conference.ConferenceCommand;
import com.omnicon.domain.conference.ConferenceInfo;
import com.omnicon.domain.conference.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConferenceFacade {

	private final ConferenceService conferenceService;

	public String registerConference(ConferenceCommand.Register register) {
		return conferenceService.registerConference(register).getConferenceToken();
	}

	public ConferenceInfo.Main retrieveConference(String conferenceToken) {
		return conferenceService.retrieveConference(conferenceToken);
	}

}
