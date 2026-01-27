package com.course.cleanarchitecture.domain.pet.core.model;

import com.course.cleanarchitecture.common.utils.checkvalue.ValidationValueUtils;
import com.course.cleanarchitecture.ddd.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class MedicalCard extends BaseEntity<UUID> {

    public List<UUID> receptionsId = new ArrayList<>();

    private LocalDateTime updateTime;

    private List<UUID> analyses = new ArrayList<>();

    private MedicalCard() {

    }

    public MedicalCard(UUID uuid, LocalDateTime updateTime, List<UUID> receptionsId, List<UUID> analyses) {
        super(uuid);
        this.updateTime = updateTime;
        this.receptionsId = receptionsId;
    }

    public void addReception(UUID id) {
        ValidationValueUtils.againstNull(id, "id reception");
        receptionsId.add(id);
        this.updateTime = LocalDateTime.now();
    }

    public static MedicalCard reStore(UUID uuid, LocalDateTime updateTime, List<UUID> receptionsId, List<UUID> analyses) {
        return new MedicalCard(uuid, updateTime, receptionsId, analyses);
    }
}
