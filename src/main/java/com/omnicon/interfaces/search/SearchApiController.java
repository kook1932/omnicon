package com.omnicon.interfaces.search;

import com.omnicon.application.video.VideoFacade;
import com.omnicon.common.response.CommonResponse;
import com.omnicon.interfaces.video.VideoDto;
import com.omnicon.interfaces.video.VideoDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
@RestController
public class SearchApiController {

	private final SearchDtoMapper searchDtoMapper;
	private final VideoFacade videoFacade;
	private final VideoDtoMapper videoDtoMapper;

	@GetMapping("/video")
	public CommonResponse<List<VideoDto.Main>> searchSummary(@Valid SearchDto.Request request) {
		var videoList = videoFacade.searchVideo(searchDtoMapper.from(request));
		return CommonResponse.success(
				videoList.stream()
						.map(videoDtoMapper::from)
						.toList()
		);
	}

}