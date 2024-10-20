package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, String>, VideoRepositoryCustom {

	Optional<Video> findByVideoToken(String videoToken);

}