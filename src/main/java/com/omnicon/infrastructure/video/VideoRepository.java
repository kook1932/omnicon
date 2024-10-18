package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, String> {

	List<Video> findTop10ByOrderByPublishedAtDesc();

}