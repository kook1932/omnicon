package com.omnicon.infrastructure.speaker;

import com.omnicon.domain.speaker.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	List<Speaker> findAllBySpeakerTokenIn(List<String> speakerTokens);
}