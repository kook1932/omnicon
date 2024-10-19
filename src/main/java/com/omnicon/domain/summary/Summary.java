package com.omnicon.domain.summary;

import com.omnicon.domain.common.DomainType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.ai.document.Document;

import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Summary {

	private String domainToken;
	private DomainType domainType;
	private Map<String, Object> domainMetaData;
	private Document document;

	public Document toDocument() {
		return new Document(
				this.domainToken,
				this.domainType.getDomainName(),
				this.domainMetaData
		);
	}

}
