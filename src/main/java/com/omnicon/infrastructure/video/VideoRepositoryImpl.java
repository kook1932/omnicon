package com.omnicon.infrastructure.video;

import com.omnicon.domain.video.VideoInfo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.omnicon.domain.video.QVideo.video;

public class VideoRepositoryImpl implements VideoRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public VideoRepositoryImpl(EntityManager entityManager) {
		this.queryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public Page<VideoInfo.Main> findAllBy(String keyword, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		if (StringUtils.hasText(keyword)) {
			builder.and(
					video.title.containsIgnoreCase(keyword)
					.or(video.description.containsIgnoreCase(keyword))
			);
		}

		JPAQuery<Long> count = queryFactory
				.select(video.id.count())
				.from(video)
				.where(builder);

		List<VideoInfo.Main> videos = queryFactory.select(Projections.fields(VideoInfo.Main.class,
						video.videoToken,
						video.youtubeVideoId,
						video.title,
						video.description,
						video.summary,
						video.publishedAt,
						video.thumbnailUrl
				))
				.from(video)
				.where(
						builder
				)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();

		return PageableExecutionUtils.getPage(videos, pageable, count::fetchOne);
	}

}
