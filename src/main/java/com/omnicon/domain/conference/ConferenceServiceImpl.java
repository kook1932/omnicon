package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.host.HostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConferenceServiceImpl implements ConferenceService {

	private final HostReader hostReader;
	private final ConferenceStore conferenceStore;
	private final ConferenceInfoMapper conferenceInfoMapper;

	@Transactional
	@Override
	public ConferenceInfo.Main registerConference(ConferenceCommand.Register register) {
		Host host = hostReader.getHostBy(register.getHostToken());
		Conference conference = conferenceStore.save(register.toEntity(host));
		return conferenceInfoMapper.from(conference);
	}

}
