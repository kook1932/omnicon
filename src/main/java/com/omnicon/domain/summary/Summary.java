package com.omnicon.domain.summary;

import com.omnicon.domain.video.Video;
import jakarta.persistence.*;

@Table(name = "summary")
@Entity
public class Summary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "video_id")
	private Video video;

	@Column(columnDefinition = "TEXT")
	private String summaryText;

}
