package com.omnicon.interfaces.host;

import com.omnicon.domain.host.HostCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface HostDtoMapper {

	HostCommand.Register from(HostDto.RegisterRequest request);

}
