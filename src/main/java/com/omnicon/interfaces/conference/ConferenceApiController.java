package com.omnicon.interfaces.conference;

import com.omnicon.application.conference.ConferenceFacade;
import com.omnicon.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/conferences")
@RestController
public class ConferenceApiController {

	private final ConferenceFacade conferenceFacade;
	private final ConferenceDtoMapper conferenceDtoMapper;

	@PostMapping
	public CommonResponse<String> createConference(@RequestBody @Valid ConferenceDto.RegisterRequest request) {
		String conferenceToken = conferenceFacade.registerConference(conferenceDtoMapper.from(request));
		return CommonResponse.success(conferenceToken);
	}

}
