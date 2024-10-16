package com.omnicon.interfaces.speaker;

import com.omnicon.application.speaker.SpeakerFacade;
import com.omnicon.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/speakers")
@RestController
public class SpeakerApiController {

	private final SpeakerFacade speakerFacade;
	private final SpeakerDtoMapper speakerDtoMapper;

	@PostMapping
	public CommonResponse<String> createSpeaker(@RequestBody @Valid SpeakerDto.RegisterRequest request) {
		String speakerToken = speakerFacade.registerSpeaker(speakerDtoMapper.from(request));
		return CommonResponse.success(speakerToken);
	}

}
