package com.omnicon.interfaces.conference;

import com.omnicon.domain.conference.ConferenceCommand;
import com.omnicon.domain.conference.ConferenceInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ConferenceDtoMapper {

	ConferenceCommand.Register from(ConferenceDto.RegisterRequest request);

	@Mapping(source = "videos", target="videos", ignore=true)
	@Mapping(source = "host", target="host", ignore=true)
	ConferenceDto.Main from(ConferenceInfo.Main conferenceInfo);

}
