package com.omnicon.domain.speaker;

import com.omnicon.common.util.KeyGenerator;
import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "speaker")
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String speakerToken;
	private String name;

	@OneToMany(mappedBy = "speaker")
	private List<VideoSpeaker> videoSpeakers;

	@Builder
	public Speaker(String name) {
		this.speakerToken = KeyGenerator.generateUUIDKey();
		this.name = name;
	}
}
