package com.omnicon.domain.common;

import com.omnicon.interfaces.search.SearchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SearchInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Request {
		private SearchType searchType;
		private String title;
		private String summary;
		private int limit = 5;
	}

}
