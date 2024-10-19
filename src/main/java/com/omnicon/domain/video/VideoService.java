package com.omnicon.domain.video;

import com.omnicon.domain.common.SearchInfo;

import java.util.List;

public interface VideoService {

	VideoInfo.Main registerVideo(VideoCommand.Register register);

//	List<VideoInfo.Main> retrieveVideo(VideoInfo.Retrieve retrieve);

}
