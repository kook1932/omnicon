package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.host.HostInfoMapper;
import com.omnicon.domain.host.HostReader;
import com.omnicon.domain.video.VideoInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConferenceServiceImpl implements ConferenceService {

	private final HostReader hostReader;
	private final HostInfoMapper hostInfoMapper;

	private final VideoInfoMapper videoInfoMapper;

	private final ConferenceReader conferenceReader;
	private final ConferenceStore conferenceStore;
	private final ConferenceInfoMapper conferenceInfoMapper;

	@Transactional
	@Override
	public ConferenceInfo.Main registerConference(ConferenceCommand.Register register) {
		Host host = hostReader.getHostBy(register.getHostToken());
		Conference conference = conferenceStore.save(register.toEntity(host));
		return conferenceInfoMapper.from(conference);
	}

	@Transactional(readOnly = true)
	@Override
	public ConferenceInfo.Main retrieveConference(String conferenceToken) {
		Conference conference = conferenceReader.getConferenceWithBy(conferenceToken);
		ConferenceInfo.Main conferenceInfo = conferenceInfoMapper.from(conference);
		conferenceInfo.setHost(hostInfoMapper.from(conference.getHost()));
		conferenceInfo.setVideos(videoInfoMapper.from(conference.getVideos()));
		return conferenceInfo;
	}

}
