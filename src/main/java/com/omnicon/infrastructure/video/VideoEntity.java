package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "video")
public class VideoEntity {

	@Id
	@Column(columnDefinition = "UUID")
	private String id;

	private String youtubeVideoId;
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	private LocalDateTime publishedAt;
	private String thumbnailUrl;
	private Integer duration;

	// 연관 관계 매핑
	// ...

	// 기본 생성자
	protected VideoEntity() {}

	// 엔티티 생성 메서드
	public static VideoEntity fromDomain(Video video) {
		VideoEntity entity = new VideoEntity();
		entity.id = video.getId();
		entity.youtubeVideoId = video.getYoutubeVideoId();
		entity.title = video.getTitle();
		// 나머지 필드 매핑
		return entity;
	}

	// 도메인 객체로 변환
	public Video toDomain() {
		Video video = new Video(id, youtubeVideoId, title);
		// 나머지 필드 매핑
		return video;
	}

}
