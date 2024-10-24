package com.omnicon.infrastructure.conference;

import com.omnicon.domain.conference.ConferenceInfo;
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

import static com.omnicon.domain.conference.QConference.conference;

public class ConferenceRepositoryImpl implements ConferenceRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public ConferenceRepositoryImpl(EntityManager entityManager) {
		this.queryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public Page<ConferenceInfo.Main> findAllBy(String keyword, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		if (StringUtils.hasText(keyword)) {
			builder.and(
					conference.name.containsIgnoreCase(keyword)
					.or(conference.description.containsIgnoreCase(keyword))
			);
		}

		JPAQuery<Long> count = queryFactory
				.select(conference.id.count())
				.from(conference)
				.where(builder);

		List<ConferenceInfo.Main> conferences = queryFactory.select(Projections.fields(ConferenceInfo.Main.class,
						conference.conferenceToken,
						conference.name,
						conference.description,
						conference.location,
						conference.websiteUrl,
						conference.startDate,
						conference.endDate
				))
				.from(conference)
				.where(
						builder
				)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();

		return PageableExecutionUtils.getPage(conferences, pageable, count::fetchOne);
	}
}
