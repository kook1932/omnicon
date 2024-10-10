package com.omnicon.domain.conference;

import com.omnicon.domain.host.HostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConferenceServiceImpl implements ConferenceService {

	private final HostStore hostStore;

	@Transactional
	@Override
	public String register(ConferenceCommand.Register register) {
		return hostStore.save(register.toEntity()).getHostToken();
	}

}
