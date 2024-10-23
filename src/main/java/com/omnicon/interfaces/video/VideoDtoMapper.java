package com.omnicon.interfaces.video;

import com.omnicon.domain.video.VideoCommand;
import com.omnicon.domain.video.VideoInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface VideoDtoMapper {

	VideoCommand.Register from(VideoDto.RegisterRequest request);

	VideoDto.Main from(VideoInfo.Main result);

	List<VideoDto.Main> from(List<VideoInfo.Main> videos);

	VideoInfo.Retrieve from(VideoDto.RetrieveRequest request);

}
