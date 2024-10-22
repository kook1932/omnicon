package com.omnicon.domain.banner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

	private final BannerStore bannerStore;
	private final BannerReader bannerReader;
	private final BannerInfoMapper bannerInfoMapper;

	@Transactional
	@Override
	public BannerInfo.Main registerBanner(BannerCommand.Register register) {
		Banner banner = bannerStore.save(register.toEntity());
		return bannerInfoMapper.from(banner);
	}

	@Transactional(readOnly = true)
	@Override
	public List<BannerInfo.Main> retrieveBanner(BannerInfo.Retrieve retrieve) {
		return bannerReader.findAllInDuration(retrieve);
	}

}
