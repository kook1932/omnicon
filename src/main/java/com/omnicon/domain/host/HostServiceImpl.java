package com.omnicon.domain.host;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class HostServiceImpl implements HostService {

	private final HostStore hostStore;

	@Transactional
	@Override
	public String register(HostCommand.Register register) {
		return hostStore.save(register.toEntity()).getHostToken();
	}

}
