package com.course.cleanarchitecture.domain.pet.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class MedicalCard extends BaseEntity<UUID> {

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private MedicalCard() {

    }

    private MedicalCard(UUID uuid, LocalDateTime createTime, LocalDateTime updateTime) {
        super(uuid);
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public static MedicalCard createMedicalCard(UUID id, LocalDateTime createTime, LocalDateTime updateTime) {
        ValidationValueUtils.againstNull(id, "id");
        ValidationValueUtils.againstNull(createTime, "createTime");
        ValidationValueUtils.againstDateTimeGreaterOrEqualCurrent(createTime, "createTime");

        if (updateTime != null) {
            ValidationValueUtils.againstDateTimeGreaterOrEqualCurrent(updateTime, "updateTime");
        }

        return new MedicalCard(id, createTime, updateTime);
    }

    public static MedicalCard reStore(UUID id, LocalDateTime createTime, LocalDateTime updateTime) {
        return new MedicalCard(id, createTime, updateTime);
    }
}
