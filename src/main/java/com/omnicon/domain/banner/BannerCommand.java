package com.omnicon.domain.banner;

import lombok.*;

import java.time.LocalDateTime;

public class BannerCommand {

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter @Setter
	public static class Register {
		private BannerType bannerType;
		private String title;
		private String imageUrl;
		private String linkUrl;
		private String description;
		private int displayOrder;
		private boolean active;
		private LocalDateTime startDate;
		private LocalDateTime endDate;

		// toEntity 메소드 작성
		public Banner toEntity() {
			return Banner.builder()
					.bannerType(bannerType)
					.title(title)
					.imageUrl(imageUrl)
					.linkUrl(linkUrl)
					.description(description)
					.displayOrder(displayOrder)
					.active(active)
					.startDate(startDate)
					.endDate(endDate)
					.build();
		}
	}

}
