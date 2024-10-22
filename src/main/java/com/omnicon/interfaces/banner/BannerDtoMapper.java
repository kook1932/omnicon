package com.omnicon.interfaces.banner;

import com.omnicon.domain.banner.BannerCommand;
import com.omnicon.domain.banner.BannerInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface BannerDtoMapper {

	BannerCommand.Register from(BannerDto.RegisterRequest request);

	BannerDto.Main from(BannerInfo.Main bannerInfo);

	BannerInfo.Retrieve from(BannerDto.RetrieveRequest request);

}
