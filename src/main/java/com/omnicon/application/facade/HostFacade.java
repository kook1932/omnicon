package com.omnicon.application.facade;

import com.omnicon.domain.host.HostCommand;
import com.omnicon.domain.host.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HostFacade {

	private final HostService hostService;

	public String registerHost(HostCommand.Register register) {
		return hostService.register(register);
	}

}
