package com.omnicon.infrastructure.banner;

import com.omnicon.domain.banner.Banner;
import com.omnicon.domain.banner.BannerStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BannerStoreImpl implements BannerStore {

	private final BannerRepository bannerRepository;

	@Override
	public Banner save(Banner banner) {
		return bannerRepository.save(banner);
	}

}
