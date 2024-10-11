package com.omnicon.domain.video;

import java.util.List;

public interface VideoReader {

	Video getVideo(String id);

	List<Video> getAllVideos();

	// 필요한 도메인 메서드 추가

}
