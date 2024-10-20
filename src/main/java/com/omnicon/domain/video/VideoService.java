package com.omnicon.domain.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoService {

	VideoInfo.Main registerVideo(VideoCommand.Register register);

	Page<VideoInfo.Main> retrieveVideo(VideoInfo.Retrieve retrieve, Pageable pageable);

	VideoInfo.Main retrieveVideo(String videoToken);

}
