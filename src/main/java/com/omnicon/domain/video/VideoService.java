package com.omnicon.domain.video;

public interface VideoService {
	VideoInfo.Main registerVideo(VideoCommand.Register register);
}
