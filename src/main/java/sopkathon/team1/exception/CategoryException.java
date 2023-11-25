package sopkathon.team1.exception;


public class CategoryException extends BusinessException {
    public CategoryException(CustomErrorCode errorCode){
        super(errorCode);
    }
}