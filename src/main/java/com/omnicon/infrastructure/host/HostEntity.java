package com.omnicon.infrastructure.host;

import com.omnicon.domain.host.Host;
import com.omnicon.infrastructure.conference.ConferenceEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "host")
public class HostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String websiteUrl;
	private String logoUrl;
	private String contactEmail;

	@OneToMany(mappedBy = "hostEntity")
	private Set<ConferenceEntity> conferences;

	public void setConferences(Set<ConferenceEntity> conferences) {
		this.conferences = conferences;
	}

	// 기본 생성자
	protected HostEntity() {}

	// 엔티티 생성 메서드
	public static HostEntity fromDomain(Host host) {
		HostEntity entity = new HostEntity();
		entity.id = host.getId();
		entity.name = host.getName();
		entity.description = host.getDescription();
		entity.websiteUrl = host.getWebsiteUrl();
		entity.logoUrl = host.getLogoUrl();
		entity.contactEmail = host.getContactEmail();
		// 나머지 필드 매핑
		return entity;
	}

	// 도메인 객체로 변환
	public Host toDomain() {
		Host host = new Host(id, name);
		host.setDescription(description);
		host.setWebsiteUrl(websiteUrl);
		host.setLogoUrl(logoUrl);
		host.setContactEmail(contactEmail);
		// 나머지 필드 매핑
		return host;
	}

}
