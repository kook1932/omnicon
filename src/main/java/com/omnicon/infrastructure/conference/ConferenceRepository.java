package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}