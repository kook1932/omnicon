package com.omnicon.interfaces.host;

import com.omnicon.application.facade.HostFacade;
import com.omnicon.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/hosts")
@RestController
public class HostApiController {

	private final HostFacade hostFacade;
	private final HostDtoMapper hostDtoMapper;

	@PostMapping
	public CommonResponse<String> createHost(@RequestBody @Valid HostDto.RegisterRequest request) {
		String hostToken = hostFacade.registerHost(hostDtoMapper.from(request));
		return CommonResponse.success(hostToken);
	}

}
