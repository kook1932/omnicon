package com.omnicon.domain.video;

import com.omnicon.domain.conference.Conference;
import com.omnicon.domain.summary.Summary;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "video")
@Entity
public class Video {

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
	private Summary summary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conference_id")
	private Conference conference;

	@OneToMany(mappedBy = "video")
	private List<VideoSpeaker> videoSpeakers;

	// 연관 관계 매핑
	// ...

}
