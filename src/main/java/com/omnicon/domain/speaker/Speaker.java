package com.omnicon.domain.speaker;

import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "speaker")
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String speakerToken;
	private String name;

	@OneToMany(mappedBy = "speaker")
	private List<VideoSpeaker> videoSpeakers;

}
