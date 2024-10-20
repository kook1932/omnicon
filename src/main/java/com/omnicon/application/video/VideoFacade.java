package com.omnicon.application.video;

import com.omnicon.domain.summary.SummaryService;
import com.omnicon.domain.video.VideoCommand;
import com.omnicon.domain.video.VideoInfo;
import com.omnicon.domain.video.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VideoFacade {

	private final VideoService videoService;
	private final SummaryService videoSummaryService;

	public String registerVideo(VideoCommand.Register register) {
		VideoInfo.Main video = videoService.registerVideo(register);
		videoSummaryService.storeSummary(video);
		return video.getVideoToken();
	}

	public Page<VideoInfo.Main> retrieveVideo(VideoInfo.Retrieve request, Pageable pageable) {
		return videoService.retrieveVideo(request, pageable);
	}

}
