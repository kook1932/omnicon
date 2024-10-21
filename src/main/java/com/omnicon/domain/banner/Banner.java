package com.omnicon.domain.banner;

import com.omnicon.common.util.KeyGenerator;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "banner")
@Entity
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String bannerToken;

	@Enumerated(value = EnumType.STRING)
	private BannerType bannerType;

	// 배너 제목
	@Column(nullable = false)
	private String title;

	// 배너 이미지 URL
	private String imageUrl;

	// 배너 클릭 시 이동할 링크 URL
	private String linkUrl;

	// 배너 설명
	@Column(length = 1000)
	private String description;

	// 노출 순서
	@Column(nullable = false)
	private int displayOrder;

	// 배너 활성화 여부
	@Column(nullable = false)
	private boolean active;

	// 배너 노출 시작 일자
	@Column(nullable = false)
	private LocalDateTime startDate;

	// 배너 노출 종료 일자
	@Column(nullable = false)
	private LocalDateTime endDate;

	@Builder
	public Banner(
			BannerType bannerType,
			String title,
			String imageUrl,
			String linkUrl,
			String description,
			int displayOrder,
			boolean active,
			LocalDateTime startDate,
			LocalDateTime endDate
	) {
		this.bannerToken = KeyGenerator.generateUUIDKey();
		this.bannerType = bannerType;
		this.title = title;
		this.imageUrl = imageUrl;
		this.linkUrl = linkUrl;
		this.description = description;
		this.displayOrder = displayOrder;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}