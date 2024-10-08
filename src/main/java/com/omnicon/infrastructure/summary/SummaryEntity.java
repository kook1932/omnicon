package com.omnicon.infrastructure.summary;

import com.omnicon.domain.video.Video;
import com.omnicon.infrastructure.video.VideoEntity;
import jakarta.persistence.*;

@Table(name = "summary")
@Entity
public class SummaryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "video_id")
	private VideoEntity video;

	@Column(columnDefinition = "TEXT")
	private String summaryText;

}
