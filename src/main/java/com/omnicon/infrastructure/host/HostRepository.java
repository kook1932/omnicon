package com.omnicon.infrastructure.host;

import com.omnicon.domain.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Long> {

	Optional<Host> findByHostToken(String hostToken);

}