package com.omnicon.domain.video.youtube;

import java.util.Optional;

public interface YtPlayerExtractor {

	/**
	 * HTML에서 ytInitialPlayerResponse 변수에 할당된 JSON 데이터를 추출합니다.
	 *
	 * @param htmlContent HTML 응답 문자열
	 * @return 추출된 JSON 데이터 문자열
	 */
	Optional<String> extractYtInitialPlayerResponse(String htmlContent);

	/**
	 * POJO 클래스를 사용하여 JSON 데이터에서 baseUrl 값을 추출합니다.
	 *
	 * @param jsonData JSON 데이터 문자열
	 * @return 추출된 baseUrl 값
	 */
	Optional<String> extractBaseUrlFromJson(String jsonData);

	/**
	 * YouTube 링크를 전달받아 해당 페이지의 HTML 콘텐츠를 문자열로 반환합니다.
	 *
	 * @param youtubeUrl YouTube 동영상 페이지의 URL
	 * @return HTML 콘텐츠 문자열
	 * @throws Exception 요청 중 오류 발생 시 예외 발생
	 */
	String fetchHtmlContent(String youtubeUrl);

}
