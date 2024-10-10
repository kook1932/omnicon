package com.omnicon.domain.video;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface VideoInfoMapper {

	VideoInfo from(Video video);

}
