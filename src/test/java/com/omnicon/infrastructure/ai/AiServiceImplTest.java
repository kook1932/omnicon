package com.omnicon.infrastructure.ai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class AiServiceImplTest {

	@Mock
	private EmbeddingModel embeddingModel;

	@InjectMocks
	private AiServiceImpl aiServiceImpl;

	@BeforeEach
	void setUp() {
		given(embeddingModel.embedForResponse(anyList())).willReturn(Mockito.mock(EmbeddingResponse.class));
	}

	@Test
	void getEmbedding() {
		EmbeddingResponse embedding = aiServiceImpl.getEmbedding("Hello World");
		Assertions.assertThat(embedding).isNotNull();
	}

}