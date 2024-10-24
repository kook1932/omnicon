package com.omnicon.interfaces.conference;

import com.omnicon.application.conference.ConferenceFacade;
import com.omnicon.common.response.CommonResponse;
import com.omnicon.domain.conference.ConferenceInfo;
import com.omnicon.interfaces.host.HostDtoMapper;
import com.omnicon.interfaces.video.VideoDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/conferences")
@RestController
public class ConferenceApiController {

	private final HostDtoMapper hostDtoMapper;
	private final VideoDtoMapper videoDtoMapper;
	private final ConferenceFacade conferenceFacade;
	private final ConferenceDtoMapper conferenceDtoMapper;

	@PostMapping
	public CommonResponse<String> createConference(@RequestBody @Valid ConferenceDto.RegisterRequest request) {
		String conferenceToken = conferenceFacade.registerConference(conferenceDtoMapper.from(request));
		return CommonResponse.success(conferenceToken);
	}

	@GetMapping("/{conferenceToken}")
	public CommonResponse<ConferenceDto.Main> getConference(@PathVariable("conferenceToken") String conferenceToken) {
		ConferenceInfo.Main conference = conferenceFacade.retrieveConference(conferenceToken);
		ConferenceDto.Main conferenceDto = conferenceDtoMapper.from(conference);
		conferenceDto.setHost(hostDtoMapper.from(conference.getHost()));
		conferenceDto.setVideos(videoDtoMapper.from(conference.getVideos()));
		return CommonResponse.success(conferenceDto);
	}
}
