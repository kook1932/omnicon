package com.omnicon.domain.speaker;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "speaker")
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String bio;

	private String photoUrl;


}
