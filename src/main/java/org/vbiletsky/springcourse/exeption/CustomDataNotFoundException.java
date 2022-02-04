package org.vbiletsky.springcourse.exeption;

public class CustomDataNotFoundException extends RuntimeException {
    public CustomDataNotFoundException() {
        super();
    }

    public CustomDataNotFoundException(String message) {
        super(message);
    }
}
