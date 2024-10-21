package com.omnicon.domain.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class BannerInfo {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public static class Main {
		private String bannerToken;
		private BannerType bannerType;
		private String title;
		private String imageUrl;
		private String linkUrl;
		private String description;
		private int displayOrder;
		private boolean active;
		private LocalDateTime startDate;
		private LocalDateTime endDate;
	}
}
