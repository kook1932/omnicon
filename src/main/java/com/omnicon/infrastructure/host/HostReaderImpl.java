package com.omnicon.infrastructure.host;

import com.omnicon.common.exception.EntityNotFoundException;
import com.omnicon.domain.host.Host;
import com.omnicon.domain.host.HostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HostReaderImpl implements HostReader {

	private final HostRepository hostRepository;

	@Override
	public Host getHostBy(String hostToken) {
		return hostRepository.findByHostToken(hostToken)
				.orElseThrow(EntityNotFoundException::new);
	}

}
