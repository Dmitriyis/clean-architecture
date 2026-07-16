package com.course.cleanarchitecture.domain.reception.adapters.in.http.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReceptionCreate(
        UUID petId,
        UUID doctorId,
        List<String> analyses,
        String conclusions,
        LocalDateTime startReception,
        LocalDateTime endReception
) { }




