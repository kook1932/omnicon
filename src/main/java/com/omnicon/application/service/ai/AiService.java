package com.omnicon.application.service.ai;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingResponse;

import java.util.List;

public interface AiService {

	String summarizeText(String text, String promptFormat);

	EmbeddingResponse getEmbedding(String text);

	List<Document> similaritySearch(String text);

	List<Document> similaritySearch(String text, int topK);

}
