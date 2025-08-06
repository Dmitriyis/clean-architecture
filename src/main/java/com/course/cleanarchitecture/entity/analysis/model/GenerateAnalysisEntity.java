package com.course.cleanarchitecture.entity.analysis.model;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;
import com.course.cleanarchitecture.entity.analysis.exceptions.AnalysisInvalidFieldException;

import java.math.BigDecimal;
import java.util.UUID;

public class GenerateAnalysisEntity {

    public static AnalysisEntity generate(UUID id, String name, Integer leadTime, BigDecimal price, String recommendations) {
        validateField(id, name, leadTime, price);
        AnalysisEntity analysisEntity = new AnalysisEntity(id, name, leadTime, price, recommendations);
        return analysisEntity;
    }

    private static void validateField(UUID id, String name, Integer leadTime, BigDecimal price) {
        validateId(id);
        validateName(name);
        validateLeadTime(leadTime);
        validatePrice(price);
    }

    public static void validateId(UUID id) {
        if (id == null) {
            String message = InvalidFieldException.prepareMessage("id", null, "Не может быть null");
            throw new AnalysisInvalidFieldException(message);
        }
    }

    public static void validateName(String name) {
        if (name == null) {
            String message = InvalidFieldException.prepareMessage("name", null, "Не может быть null");
            throw new AnalysisInvalidFieldException(message);
        }

        if (name.isEmpty()) {
            String message = InvalidFieldException.prepareMessage("name", "", "Не может быть empty");
            throw new AnalysisInvalidFieldException(message);
        }

        if (name.length() < 3) {
            String message = InvalidFieldException.prepareMessage("name", name, "Не может быть меньше 3 символов");
            throw new AnalysisInvalidFieldException(message);
        }

        if (name.length() > 15) {
            String message = InvalidFieldException.prepareMessage("name", name, "Не может быть больше");
            throw new AnalysisInvalidFieldException(message);
        }
    }

    public static void validateLeadTime(Integer leadTime) {
        if (leadTime == null) {
            String message = InvalidFieldException.prepareMessage("leadTime", null, "Не может быть null");
            throw new AnalysisInvalidFieldException(message);
        }

        if (leadTime < 1) {
            String message = InvalidFieldException.prepareMessage("leadTime", leadTime, "Не может быть меньше 1");
            throw new AnalysisInvalidFieldException(message);
        }
    }

    public static void validatePrice(BigDecimal price) {
        if (price == null) {
            String message = InvalidFieldException.prepareMessage("price", null, "Не может быть null");
            throw new AnalysisInvalidFieldException(message);
        }

        if (price.doubleValue() < 1) {
            String message = InvalidFieldException.prepareMessage("price", null, "Не может быть меьше 1");
            throw new AnalysisInvalidFieldException(message);
        }
    }
}

