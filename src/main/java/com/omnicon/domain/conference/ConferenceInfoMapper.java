package com.omnicon.domain.conference;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ConferenceInfoMapper {

	@Mapping(source = "conference.videos", target="videos", ignore=true)
	@Mapping(source = "conference.host", target="host", ignore=true)
	ConferenceInfo.Main from(Conference conference);

}