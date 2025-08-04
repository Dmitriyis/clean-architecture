package com.course.cleanarchitecture.common.exceptions;

public abstract class NotFoundException extends RuntimeException {

    /**
     * Шаблон сообщения об ошибке.
     * Параметры шаблона:
     * 1. Тип сущности (какой объект ищем)
     * 2. Имя поля (названия парамтера по которому ищем)
     * 3. Значение поля (значения параметра по которуму ищем)
     */
    private static final String MESSAGE_TEMPLATE = "Не найден %s по %s: [%s]";

    public NotFoundException(String message) {
        super(message);
    }

    public static String prepareMessage(String nameObject, String nameParameter, String valueParameter) {
        return String.format(MESSAGE_TEMPLATE, nameObject, nameParameter, valueParameter);
    }
}
