package com.course.cleanarchitecture.domain.pet.adapters.in.http.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record MedicalCardUpdate(UUID id, List<UUID> receptionsId, LocalDateTime updateTime) {


}
