package com.omnicon.application.service;

import com.omnicon.application.service.ai.AiServiceImpl;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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