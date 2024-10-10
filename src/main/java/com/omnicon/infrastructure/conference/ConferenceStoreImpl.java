package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.conference.ConferenceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConferenceStoreImpl implements ConferenceStore {

	private final ConferenceRepository conferenceRepository;

	@Override
	public Conference save(Conference conference) {
		return conferenceRepository.save(conference);
	}

}
