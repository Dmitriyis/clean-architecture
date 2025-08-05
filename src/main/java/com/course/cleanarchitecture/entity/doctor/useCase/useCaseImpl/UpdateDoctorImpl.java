package com.course.cleanarchitecture.entity.doctor.useCase.useCaseImpl;

import com.course.cleanarchitecture.common.exceptions.NotFoundException;
import com.course.cleanarchitecture.entity.doctor.exceptions.DoctorNotFoundException;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.UpdateDoctorUseCase;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;
import com.course.cleanarchitecture.entity.doctor.useCase.mapper.DoctorMapper;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.GetDoctorByIdProvider;
import com.course.cleanarchitecture.entity.doctor.useCase.provider.UpdateDoctorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateDoctorImpl implements UpdateDoctorUseCase {

    private final DoctorMapper doctorMapper;
    private final UpdateDoctorProvider updateDoctorProvider;
    private final GetDoctorByIdProvider getDoctorByIdProvider;

    @Override
    public UUID execute(DoctorUpdateDto doctorUpdateDto) {
        DoctorEntity doctorEntityFromDataBase = getDoctorByIdProvider.execute(doctorUpdateDto.getId())
                .orElseThrow(() -> {
                    String message = NotFoundException.prepareMessage("DoctorEntity", "id", doctorUpdateDto.getId()
                            .toString());
                    return new DoctorNotFoundException(message);
                });


        DoctorEntity doctorEntityUpdated = doctorMapper.toDoctorEntity(doctorUpdateDto, doctorEntityFromDataBase);

        return updateDoctorProvider.execute(doctorEntityUpdated);
    }
}
