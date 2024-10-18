package com.omnicon.domain.video;

import java.util.List;

public interface VideoService {

	VideoInfo.Main registerVideo(VideoCommand.Register register);

	List<VideoInfo.Main> getTop10Videos();

}
