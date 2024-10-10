package com.omnicon.infrastructure.host;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.host.HostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HostStoreImpl implements HostStore {

	private final HostRepository hostRepository;

	@Override
	public Host save(Host host) {
		return hostRepository.save(host);
	}

}
