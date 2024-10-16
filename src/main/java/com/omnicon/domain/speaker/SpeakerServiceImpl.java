package com.omnicon.domain.speaker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SpeakerServiceImpl implements SpeakerService {

	private final SpeakerStore speakerStore;
	private final SpeakerInfoMapper speakerInfoMapper;

	@Transactional
	@Override
	public SpeakerInfo.Main registerSpeaker(SpeakerCommand.Register register) {
		Speaker speaker = speakerStore.save(register.toEntity());
		return speakerInfoMapper.from(speaker);
	}

}
