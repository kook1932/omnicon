package com.omnicon.infrastructure.ai;

import com.omnicon.interfaces.ai.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AiServiceImpl implements AiService {

	private final ChatModel chatModel;
	private final EmbeddingModel embeddingModel;
	private final VectorStore vectorStore;

	@Override
	public String summarizeText(String text, String promptFormat) {
		String prompt = String.format(promptFormat, text);
		return chatModel.call(prompt);
	}

	@Override
	public EmbeddingResponse getEmbedding(String text) {
		return embeddingModel.embedForResponse(List.of(text));
	}

	@Override
	public List<Document> similaritySearch(String text) {
		return vectorStore.similaritySearch(
				SearchRequest.defaults()
						.withQuery(text));
	}

	@Override
	public List<Document> similaritySearch(String text, int topK) {
		return vectorStore.similaritySearch(
				SearchRequest.defaults()
						.withQuery(text)
						.withTopK(topK)
		);
	}

}
