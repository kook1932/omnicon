package com.omnicon.domain.conference;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConferenceReader {

	Conference getConferenceBy(String conferenceToken);

	Conference getConferenceWithBy(String conferenceToken);

	Page<Conference> findAllBy(ConferenceInfo.Retrieve retrieve, Pageable pageable);

}
