package com.course.cleanarchitecture.common.hibernate.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashMap;
import java.util.Map;

@Converter
public class MapToArrayConverter implements AttributeConverter<Map<String, String>, String[]> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String[] convertToDatabaseColumn(Map<String, String> stringStringMap) {
        if(stringStringMap == null || stringStringMap.isEmpty()) {
            return null;
        }

        try {
            String value = objectMapper.writeValueAsString(stringStringMap);
            return new String[]{value};
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting map to JSON", e);
        }

    }

    @Override
    public Map<String, String> convertToEntityAttribute(String[] dbData) {
        if (dbData == null || dbData.length == 0) {
            return new HashMap<>();
        }

        try {
            return objectMapper.readValue(dbData[0], new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to map", e);
        }
    }
}
