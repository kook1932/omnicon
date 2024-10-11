package com.omnicon.infrastructure.video.videospeaker;

import com.omnicon.domain.video.videospeaker.VideoSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoSpeakerRepository extends JpaRepository<VideoSpeaker, Long> {
}