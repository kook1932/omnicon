package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class Conference {

	private Long id;
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String location;
	private String websiteUrl;

	private Host host; // 주최자

	private Set<Video> videos = new HashSet<>();

	// 생성자
	public Conference(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	// 회사 설정 메서드
	public void setCompany(Host host) {
		this.host = host;
	}

	// 비즈니스 로직 메서드
	public void addVideo(Video video) {
		videos.add(video);
		video.assignConference(this);
	}

	// 기타 비즈니스 로직

}
