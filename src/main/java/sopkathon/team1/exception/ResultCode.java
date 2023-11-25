package sopkathon.team1.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ResultCode {
    GET_POSTS_SUCCESS(HttpStatus.OK, "카테고리별 다이어리 조회 성공");

    private final HttpStatus status;
    private final String message;
}