package com.omnicon.domain.conference;

public interface ConferenceReader {

	Conference getConferenceBy(String conferenceToken);

	Conference getConferenceWithBy(String conferenceToken);

}
