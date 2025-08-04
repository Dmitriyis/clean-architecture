package com.course.cleanarchitecture.common.extensionsCollections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCommon<T> {
    public static <T> List<T> of(T ... elements) {
        return Stream.of(elements).collect(Collectors.toList());
    }
}
