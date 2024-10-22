package com.omnicon.domain.banner;

import java.time.LocalDateTime;
import java.util.List;

public interface BannerService {

	BannerInfo.Main registerBanner(BannerCommand.Register command);

	List<BannerInfo.Main> retrieveBanner(BannerInfo.Retrieve retrieve);

}
