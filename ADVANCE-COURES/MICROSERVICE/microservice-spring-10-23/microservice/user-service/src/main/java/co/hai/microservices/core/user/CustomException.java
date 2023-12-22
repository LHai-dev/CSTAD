package co.hai.microservices.core.user;

public class CustomException extends RuntimeException {
    private String message;
    private String errorCode;
    private int httpStatus;

    public CustomException(String message, String errorCode, int httpStatus) {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}