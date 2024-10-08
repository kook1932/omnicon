package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.summary.Summary;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Video {
	private Long id;
	private String youtubeVideoId;
	private String title;
	private LocalDateTime publishedAt;
	private String thumbnailUrl;
	private Integer duration;
	private Conference conference;
	private Set<Speaker> speakers = new HashSet<>();
	private Summary summary;

	// 생성자
	public Video(Long id, String youtubeVideoId, String title) {
		this.id = id;
		this.youtubeVideoId = youtubeVideoId;
		this.title = title;
	}

	// 비즈니스 로직 메서드
	public void addSpeaker(Speaker speaker) {
		speakers.add(speaker);
	}

	public void assignConference(Conference conference) {
		this.conference = conference;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	// 기타 비즈니스 로직

}
