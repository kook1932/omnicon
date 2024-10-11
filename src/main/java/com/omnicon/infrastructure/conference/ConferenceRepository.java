package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

	Optional<Conference> findByConferenceToken(String conferenceToken);

}