package com.omnicon.interfaces.banner;

import com.omnicon.application.banner.BannerFacade;
import com.omnicon.common.response.CommonResponse;
import com.omnicon.domain.banner.BannerInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.List;

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

	@GetMapping
	public CommonResponse<List<BannerDto.Main>> retrieveBanner(@Valid BannerDto.RetrieveRequest request) {
		request.setNow(LocalDateTime.now());
		List<BannerInfo.Main> bannerList = bannerFacade.retrieveBanner(bannerDtoMapper.from(request));

		return CommonResponse.success(
				bannerList.stream()
						.map(bannerDtoMapper::from)
						.toList()
		);
	}
}
