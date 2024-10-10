package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {
}