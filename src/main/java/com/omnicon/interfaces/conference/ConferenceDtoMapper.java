package com.omnicon.interfaces.conference;

import com.omnicon.domain.conference.ConferenceCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ConferenceDtoMapper {

	ConferenceCommand.Register from(ConferenceDto.RegisterRequest request);

}
