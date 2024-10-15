package com.omnicon.interfaces.video;

import com.omnicon.domain.video.VideoCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface VideoDtoMapper {

	VideoCommand.Register from(VideoDto.RegisterRequest request);

}
