package com.omnicon.domain.video.videospeaker;

import com.omnicon.domain.speaker.Speaker;
import com.omnicon.domain.video.Video;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

	@Builder
	public VideoSpeaker(Video video, Speaker speaker) {
		this.video = video;
		this.speaker = speaker;
	}

}
