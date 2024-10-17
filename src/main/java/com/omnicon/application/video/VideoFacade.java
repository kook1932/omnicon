package com.omnicon.application.video;

import com.omnicon.application.search.SearchService;
import com.omnicon.domain.common.SearchInfo;
import com.omnicon.domain.summary.SummaryService;
import com.omnicon.domain.video.VideoCommand;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.domain.video.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VideoFacade {

	private final VideoService videoService;
	private final SummaryService summaryService;
	private final SearchService<VideoInfo.Main> videoSearchService;

	public String registerVideo(VideoCommand.Register register) {
		VideoInfo.Main video = videoService.registerVideo(register);
		summaryService.storeSummary(video);
		return video.getVideoToken();
	}

	public List<VideoInfo.Main> searchVideo(SearchInfo.Request search) {
		return videoSearchService.searchVideo(search);
	}


}
