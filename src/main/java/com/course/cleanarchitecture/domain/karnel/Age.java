package com.course.cleanarchitecture.domain.karnel;


import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.ValueObject;
import lombok.Getter;

import java.util.List;

@Getter
public class Age extends ValueObject<Age> {

    private Integer volume;

    private Age() {

    }

    public Age(Integer volume) {
        ValidationValueUtils.againstNegative(volume, "volume");
        ValidationValueUtils.againstNull(volume, "volume");

        this.volume = volume;
    }

    @Override
    protected List<Object> equalityComponents() {
        return List.of(volume);
    }
}
