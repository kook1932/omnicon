package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.video.Video;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "conference")
public class Conference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String conferenceToken;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private LocalDate startDate;
	private LocalDate endDate;
	private String location;
	private String websiteUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_entity_id")
	private Host host;

	@OneToMany(mappedBy = "conference")
	private List<Video> videos;

	@Builder
	public Conference(
			String name,
			String description,
			LocalDate startDate,
			LocalDate endDate,
			String location,
			String websiteUrl,
			Host host
	) {
		this.conferenceToken = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.websiteUrl = websiteUrl;
		this.host = host;
	}
}