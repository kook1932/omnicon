package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.Conference;
import com.omnicon.infrastructure.host.HostEntity;
import com.omnicon.infrastructure.video.VideoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Table(name = "conference")
public class ConferenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private LocalDate startDate;
	private LocalDate endDate;
	private String location;
	private String websiteUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_entity_id")
	private HostEntity hostEntity;

	@OneToMany(mappedBy = "conference")
	private Set<VideoEntity> videos;

	// 기본 생성자
	protected ConferenceEntity() {}

	// 엔티티 생성 메서드
	public static ConferenceEntity fromDomain(Conference conference) {
		ConferenceEntity entity = new ConferenceEntity();
		entity.id = conference.getId();
		entity.name = conference.getName();
		entity.description = conference.getDescription();
		entity.startDate = conference.getStartDate();
		entity.endDate = conference.getEndDate();
		entity.location = conference.getLocation();
		entity.websiteUrl = conference.getWebsiteUrl();

		if (conference.getHost() != null) {
			entity.hostEntity = HostEntity.fromDomain(conference.getHost());
		}

		// 나머지 필드 매핑
		return entity;
	}

	// 도메인 객체로 변환
	public Conference toDomain() {
		Conference conference = new Conference(id, name);
		conference.setDescription(description);
		conference.setStartDate(startDate);
		conference.setEndDate(endDate);
		conference.setLocation(location);
		conference.setWebsiteUrl(websiteUrl);

		if (hostEntity != null) {
			conference.setCompany(hostEntity.toDomain());
		}

		// 나머지 필드 매핑
		return conference;
	}

}