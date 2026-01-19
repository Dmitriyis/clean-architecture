package com.course.cleanarchitecture.common.hibernate.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter(autoApply = false)
public class ListToArrayConverter implements AttributeConverter<List<String>, String[]> {

    @Override
    public String[] convertToDatabaseColumn(List<String> list) {
        return list == null ? null : list.toArray(new String[0]);
    }

    @Override
    public List<String> convertToEntityAttribute(String[] array) {
        return array == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(array));
    }
}
