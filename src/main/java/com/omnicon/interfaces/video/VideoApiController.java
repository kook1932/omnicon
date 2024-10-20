package com.omnicon.interfaces.video;

import com.omnicon.application.video.VideoFacade;
import com.omnicon.common.response.CommonResponse;
import com.omnicon.domain.video.VideoInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping
	public CommonResponse<Page<VideoInfo.Main>> retrieveVideos(@Valid VideoDto.RetrieveRequest request,
															   @PageableDefault Pageable pageable) {

		var videoPage = videoFacade.retrieveVideo(videoDtoMapper.from(request), pageable);
		return CommonResponse.success(videoPage);
	}

	@GetMapping("/{videoToken}")
	public CommonResponse<VideoDto.Main> retrieveVideo(@PathVariable("videoToken") String videoToken) {
		var video = videoFacade.retrieveVideo(videoToken);
		return CommonResponse.success(videoDtoMapper.from(video));
	}

}
