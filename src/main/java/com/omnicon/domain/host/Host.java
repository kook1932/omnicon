package com.omnicon.domain.host;

import com.omnicon.domain.conference.Conference;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class Host {

	private Long id;
	private String name;
	private String description;
	private String websiteUrl;
	private String logoUrl;
	private String contactEmail;

	private Set<Conference> conferences = new HashSet<>();

	// 생성자
	public Host(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// 비즈니스 로직 메서드
	public void addConference(Conference conference) {
		conferences.add(conference);
		conference.setCompany(this);
	}


}
