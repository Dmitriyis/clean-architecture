package com.course.cleanarchitecture.domain.pet.adapters.in.http.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class MedicalCardUpdate {

    private UUID id;

    private List<UUID> receptionsId;

    private LocalDateTime updateTime;
}
