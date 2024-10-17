package com.omnicon.interfaces.search;

import lombok.Data;

public class SearchDto {

	@Data
	public static class Request {
		private SearchType searchType;
		private String title;
		private String summary;
		private int limit = 5;
	}

}
