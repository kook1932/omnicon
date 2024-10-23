package com.omnicon.domain.host;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface HostInfoMapper {

	@Mapping(source = "conferences", target = "conferences", ignore = true)
	HostInfo.Main from(Host host);

}
