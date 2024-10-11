package com.omnicon.domain.speaker;

import java.util.List;

public interface SpeakerReader {

	List<Speaker> getAllSpeakers(List<String> speakerTokens);

}
