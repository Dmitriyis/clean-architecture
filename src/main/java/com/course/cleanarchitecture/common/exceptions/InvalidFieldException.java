package com.course.cleanarchitecture.common.exceptions;

public abstract class InvalidFieldException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Не валидный %s: [%s]. Сообщения ошибка: %s.";

    public InvalidFieldException(String message) {
        super(message);
    }

    public static String prepareMessage(String nameParameter, Object value, String description) {
        return String.format(MESSAGE_TEMPLATE, nameParameter, value, description);
    }
}
