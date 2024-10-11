package com.omnicon.domain.summary;

import com.omnicon.domain.video.VideoInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.document.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Summary {

	private String videoToken;
	private String summaryText;
	private VideoInfo.Main video;
	private Document document;

	public Document toDocument() {
		return new Document(
				this.videoToken,
				this.summaryText,
				this.video.toMetadataMap()
		);
	}

}
