package com.omnicon.infrastructure.banner;

import com.omnicon.domain.banner.Banner;
import com.omnicon.domain.banner.BannerInfo;
import com.omnicon.domain.banner.BannerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

	@Query(
			"select b " +
			"from Banner b " +
			"where b.active = true " +
				"and b.bannerType = :#{#retrieve.bannerType} " +
				"and b.startDate <= :#{#retrieve.now} and b.endDate >= :#{#retrieve.now} " +
			"order by b.displayOrder"
	)
	List<Banner> findAllInDuration(@Param("retrieve") BannerInfo.Retrieve retrieve);

}