package com.omnicon.infrastructure.speaker;

import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.speaker.SpeakerStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpeakerStoreImpl implements SpeakerStore {

	private final SpeakerRepository speakerRepository;

	@Override
	public Speaker save(Speaker speaker) {
		return speakerRepository.save(speaker);
	}

}
