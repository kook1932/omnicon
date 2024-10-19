package com.omnicon.interfaces.video;

import com.omnicon.application.video.VideoFacade;
import com.omnicon.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/videos")
@RestController
public class VideoApiController {

	private final VideoFacade videoFacade;
	private final VideoDtoMapper videoDtoMapper;

	@PostMapping
	public CommonResponse<String> register(@RequestBody @Valid VideoDto.RegisterRequest request) {
		String videoToken = videoFacade.registerVideo(videoDtoMapper.from(request));
		return CommonResponse.success(videoToken);
	}

//	@GetMapping
//	public CommonResponse<List<VideoDto.Main>> retrieveVideos(@Valid VideoDto.RetrieveRequest request) {
//		var videoList = videoFacade.retrieveVideo(videoDtoMapper.from(request));
//		return CommonResponse.success(
//				videoList.stream()
//						.map(videoDtoMapper::from)
//						.toList()
//		);
//	}

}
