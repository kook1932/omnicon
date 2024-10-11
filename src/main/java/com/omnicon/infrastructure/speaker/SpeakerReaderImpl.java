package com.omnicon.infrastructure.speaker;

import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.speaker.SpeakerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SpeakerReaderImpl implements SpeakerReader {

	private final SpeakerRepository speakerRepository;

	@Override
	public List<Speaker> getAllSpeakers(List<String> speakerTokens) {
		return speakerRepository.findAllBySpeakerTokenIn(speakerTokens);
	}

}
