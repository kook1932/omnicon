package com.omnicon.infrastructure.banner;

import com.omnicon.domain.banner.BannerInfo;
import com.omnicon.domain.banner.BannerInfoMapper;
import com.omnicon.domain.banner.BannerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BannerReaderImpl implements BannerReader {

	private final BannerRepository bannerRepository;
	private final BannerInfoMapper bannerInfoMapper;

	@Override
	public List<BannerInfo.Main> findAllInDuration(BannerInfo.Retrieve retrieve) {
		return bannerRepository.findAllInDuration(retrieve).stream()
				.map(bannerInfoMapper::from)
				.toList();
	}

}
