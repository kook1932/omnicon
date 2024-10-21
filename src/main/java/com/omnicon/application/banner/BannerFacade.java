package com.omnicon.application.banner;

import com.omnicon.domain.banner.BannerCommand;
import com.omnicon.domain.banner.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BannerFacade {

	private final BannerService bannerService;

	public String registerBanner(BannerCommand.Register register) {
		return bannerService.registerBanner(register).getBannerToken();
	}

}
