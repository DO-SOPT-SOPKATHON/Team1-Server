package sopkathon.team1.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum CustomErrorCode {

    CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "카테고리가 존재하지 않습니다");

    private final HttpStatus status;
    private final String message;
}