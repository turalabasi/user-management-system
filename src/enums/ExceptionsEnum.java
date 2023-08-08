package enums;

import java.time.LocalDateTime;

public enum ExceptionsEnum {
    WRONG_FORMAT("wrong format", LocalDateTime.now()),
    USERNAME_NOT_FOUND("username not found", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option exception", LocalDateTime.now()),
    EMPTY_LIST_EXCEPTION("Empty list exception", LocalDateTime.now());
    ExceptionsEnum(String message, LocalDateTime localDateTime) {
        this.message=message;
        this.localDateTime=localDateTime;
    }
    String message;
    LocalDateTime localDateTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
