package com.omnicon.domain.host;

import com.omnicon.domain.conference.Conference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "host")
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hostToken;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String websiteUrl;
	private String logoUrl;

	@OneToMany(mappedBy = "host")
	private List<Conference> conferences;

	@Builder
	public Host(String name, String description, String websiteUrl, String logoUrl) {
		this.hostToken = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.websiteUrl = websiteUrl;
		this.logoUrl = logoUrl;
	}
}
