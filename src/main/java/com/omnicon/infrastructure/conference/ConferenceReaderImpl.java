package com.omnicon.infrastructure.conference;

import com.omnicon.common.exception.EntityNotFoundException;
import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.conference.ConferenceReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConferenceReaderImpl implements ConferenceReader {

	private final ConferenceRepository conferenceRepository;

	@Override
	public Conference getConferenceBy(String conferenceToken) {
		return conferenceRepository.findByConferenceToken(conferenceToken)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Conference getConferenceWithBy(String conferenceToken) {
		return conferenceRepository.findConferenceWithBy(conferenceToken)
				.orElseThrow(EntityNotFoundException::new);
	}

}
