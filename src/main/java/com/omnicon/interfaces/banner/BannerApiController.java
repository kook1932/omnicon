package com.omnicon.interfaces.banner;

import com.omnicon.application.banner.BannerFacade;
import com.omnicon.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/banners")
@RestController
public class BannerApiController {

	private final BannerFacade bannerFacade;
	private final BannerDtoMapper bannerDtoMapper;

	@PostMapping
	public CommonResponse<String> registerBanner(@RequestBody @Valid BannerDto.RegisterRequest request) {
		String bannerToken = bannerFacade.registerBanner(bannerDtoMapper.from(request));
		return CommonResponse.success(bannerToken);
	}

}
