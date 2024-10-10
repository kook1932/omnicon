package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import com.omnicon.infrastructure.conference.ConferenceEntity;
import com.omnicon.infrastructure.summary.SummaryEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
@Entity
public class VideoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String videoToken;

	private String youtubeVideoId;
	private String title;

	private LocalDateTime publishedAt;
	private String thumbnailUrl;
	private Integer duration;

	@OneToOne(mappedBy = "video", cascade = CascadeType.ALL)
	private SummaryEntity summary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private ConferenceEntity conference;

	// 연관 관계 매핑
	// ...

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
