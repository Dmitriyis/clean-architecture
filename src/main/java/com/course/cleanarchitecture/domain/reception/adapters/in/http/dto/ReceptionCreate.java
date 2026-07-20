package com.course.cleanarchitecture.domain.reception.adapters.in.http.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReceptionCreate(
        UUID petId,
        UUID doctorId,
        List<String> analysesDirection,
        String description,
        LocalDateTime startReception,
        LocalDateTime endReception
) {};




