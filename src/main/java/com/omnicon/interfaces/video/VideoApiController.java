package com.omnicon.interfaces.video;

import com.omnicon.application.facade.VideoFacade;
import com.omnicon.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/videos")
@RestController
public class VideoApiController {

	private final VideoFacade videoFacade;
	private final VideoDtoMapper videoDtoMapper;

	@PostMapping
	public CommonResponse<String> register(VideoDto.RegisterRequest request) {
		String videoToken = videoFacade.registerVideo(videoDtoMapper.from(request));
		return CommonResponse.success(videoToken);
	}

}
