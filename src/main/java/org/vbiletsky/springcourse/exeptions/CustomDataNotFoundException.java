package org.vbiletsky.springcourse.exeptions;

public class CustomDataNotFoundException extends RuntimeException {
    public CustomDataNotFoundException() {
        super();
    }

    public CustomDataNotFoundException(String message) {
        super(message);
    }
}
