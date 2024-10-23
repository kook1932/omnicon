package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

	Optional<Conference> findByConferenceToken(String conferenceToken);

	@Query(" select distinct c " +
			"from Conference c " +
			"join fetch c.host " +
			"join fetch c.videos " +
			"where c.conferenceToken = :conferenceToken")
	Optional<Conference> findConferenceWithBy(@Param("conferenceToken") String conferenceToken);

}