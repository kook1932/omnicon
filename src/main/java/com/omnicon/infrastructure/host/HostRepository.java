package com.omnicon.infrastructure.host;

import com.omnicon.domain.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}