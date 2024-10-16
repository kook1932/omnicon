package com.omnicon.interfaces.speaker;

import com.omnicon.domain.speaker.SpeakerCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SpeakerDtoMapper {

	SpeakerCommand.Register from(SpeakerDto.RegisterRequest request);

}
