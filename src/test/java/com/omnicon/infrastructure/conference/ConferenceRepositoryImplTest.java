package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.ConferenceInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ConferenceRepositoryImplTest {

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Test
	void findAllByTest() {
		// when
		Page<ConferenceInfo.Main> allBy = conferenceRepository.findAllBy("모두", PageRequest.of(0, 10));

		// then
		Assertions.assertThat(allBy.getContent()).isNotNull();
	}
}