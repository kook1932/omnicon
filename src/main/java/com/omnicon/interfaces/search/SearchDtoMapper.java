package com.omnicon.interfaces.search;

import com.omnicon.domain.common.SearchInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SearchDtoMapper {

	SearchInfo.Request from(SearchDto.Request request);

}
