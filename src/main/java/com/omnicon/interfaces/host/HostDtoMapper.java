package com.omnicon.interfaces.host;

import com.omnicon.domain.host.HostCommand;
import com.omnicon.domain.host.HostInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface HostDtoMapper {

	HostCommand.Register from(HostDto.RegisterRequest request);

	@Mapping(source = "conferences", target = "conferences", ignore = true)
	HostDto.Main from(HostInfo.Main hostInfo);

}
