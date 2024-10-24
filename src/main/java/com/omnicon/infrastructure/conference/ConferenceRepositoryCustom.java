package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.ConferenceInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConferenceRepositoryCustom {

	Page<ConferenceInfo.Main> findAllBy(String keyword, Pageable pageable);

}
