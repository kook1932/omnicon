package com.omnicon.application.search;

import com.omnicon.domain.common.SearchInfo;

import java.util.List;

public interface SearchService<T> {

	List<T> searchVideo(SearchInfo.Request search);

}
