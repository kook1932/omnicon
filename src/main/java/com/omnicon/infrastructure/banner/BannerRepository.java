package com.omnicon.infrastructure.banner;

import com.omnicon.domain.banner.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long> {
}