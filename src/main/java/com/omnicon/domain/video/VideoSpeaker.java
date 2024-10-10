package com.omnicon.domain.video;

import com.omnicon.domain.speaker.Speaker;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "video_speaker")
@Entity
public class VideoSpeaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "video_id")
	private Video video;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "speaker_id")
	private Speaker speaker;

}
