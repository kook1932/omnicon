package com.omnicon.domain.video;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface VideoInfoMapper {

	VideoInfo.Main from(Video video);

	List<VideoInfo.Main> from(List<Video> video);

}
