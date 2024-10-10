package com.omnicon.domain.conference;

import com.omnicon.domain.host.Host;
import com.omnicon.domain.video.Video;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "conference")
public class Conference {

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
	private Host host;

	@OneToMany(mappedBy = "conference")
	private List<Video> videos;

	// 기본 생성자
	protected Conference() {}

}