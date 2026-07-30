package com.course.cleanarchitecture.domain.reception.core.application.queries;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GetAllReceptionByPetIdResponse(UUID petId,
                                             UUID doctorId,
                                             List<String> analysesDirection,
                                             String description,
                                             LocalDateTime startReception,
                                             LocalDateTime endReception) {
}
