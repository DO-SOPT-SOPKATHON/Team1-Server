package sopkathon.team1.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessException extends RuntimeException {
    private CustomErrorCode errorCode;
    public BusinessException(String message, CustomErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(CustomErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}