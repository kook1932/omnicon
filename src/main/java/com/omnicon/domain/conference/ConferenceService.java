package com.omnicon.domain.conference;

public interface ConferenceService {

	ConferenceInfo.Main registerConference(ConferenceCommand.Register register);

}