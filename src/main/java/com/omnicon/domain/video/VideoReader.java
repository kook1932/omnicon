package com.omnicon.domain.video;

import java.util.List;

public interface VideoReader {

	Video getVideo(String id);

	List<Video> getTop10Videos();

}
