package enums;

public enum InfoWordsEnum {
    WELCOME_USERNAME("------Welcome username--------");

    InfoWordsEnum(String message) {
        this.message=message;

    }
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
