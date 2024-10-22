package com.omnicon.interfaces.banner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.omnicon.domain.banner.BannerType;
import lombok.Data;

import java.time.LocalDateTime;

public class BannerDto {

	@Data
	public static class RegisterRequest {
		private BannerType bannerType;
		private String title;
		private String imageUrl;
		private String linkUrl;
		private String description;
		private int displayOrder;
		private boolean active;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private LocalDateTime startDate;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private LocalDateTime endDate;
	}

	@Data
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

	@Data
	public static class RetrieveRequest {
		private LocalDateTime now;
		private BannerType bannerType;
	}

}
