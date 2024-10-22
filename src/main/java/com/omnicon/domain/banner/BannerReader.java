package com.omnicon.domain.banner;

import java.util.List;

public interface BannerReader {

	List<BannerInfo.Main> findAllInDuration(BannerInfo.Retrieve retrieve);

}
