package com.omnicon.domain.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DomainType {
	HOST("host"),
	CONFERENCE("conference"),
	VIDEO("video"),
	SPEAKER("speaker");

	private final String domainName;
}
