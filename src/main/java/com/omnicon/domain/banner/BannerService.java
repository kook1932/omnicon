package com.omnicon.domain.banner;

public interface BannerService {

	BannerInfo.Main registerBanner(BannerCommand.Register command);

}
