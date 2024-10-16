package com.omnicon.domain.video;

import com.omnicon.common.util.KeyGenerator;
import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String videoToken;

	private String youtubeVideoId;
	private String title;
	private String description;

	private LocalDateTime publishedAt;
	private String thumbnailUrl;
	private Integer duration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;

	@OneToMany(mappedBy = "video")
	private List<VideoSpeaker> videoSpeakers = new ArrayList<>();

	@Builder
	public Video(
			String youtubeVideoId,
			String title,
			String description,
			LocalDateTime publishedAt,
			String thumbnailUrl,
			Integer duration
	) {
		this.videoToken = KeyGenerator.generateUUIDKey();
		this.youtubeVideoId = youtubeVideoId;
		this.title = title;
		this.description = description;
		this.publishedAt = publishedAt;
		this.thumbnailUrl = thumbnailUrl;
		this.duration = duration;
	}

	// 연관 관계 매핑
	public void setConference(Conference conference) {
		this.conference = conference;
		conference.getVideos().add(this);
	}


}
