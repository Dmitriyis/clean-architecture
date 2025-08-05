package com.course.cleanarchitecture.entity.doctor.useCase.mapper;

import com.course.cleanarchitecture.entity.appointment.useCase.dto.AppointmentResponseDto;
import com.course.cleanarchitecture.entity.appointment.useCase.mapper.AppointmentMapper;
import com.course.cleanarchitecture.entity.doctor.model.DoctorEntity;
import com.course.cleanarchitecture.entity.doctor.model.GenerateDoctorEntity;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorRequestDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorResponseDto;
import com.course.cleanarchitecture.entity.doctor.useCase.dto.DoctorUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorMapperImpl implements DoctorMapper {

    private AppointmentMapper appointmentMapper;

    @Override
    public DoctorEntity toDoctorEntity(DoctorRequestDto doctorRequestDto, UUID id) {
        DoctorEntity doctorEntity = GenerateDoctorEntity.generate(id, doctorRequestDto.getName(), doctorRequestDto.getProfession(), doctorRequestDto.getWorkExperience());
        return doctorEntity;
    }

    @Override
    public DoctorEntity toDoctorEntity(DoctorUpdateDto doctorUpdateDto, DoctorEntity doctorEntity) {
        doctorEntity.updateName(doctorUpdateDto.getName());
        doctorEntity.updateProfession(doctorUpdateDto.getProfession());
        doctorEntity.updateWorkExperience(doctorUpdateDto.getWorkExperience());
        return doctorEntity;
    }

    @Override
    public DoctorResponseDto toDoctorResponseDto(DoctorEntity doctorEntity) {
        List<AppointmentResponseDto> appointmentRequestDtos = doctorEntity.getAppointments()
                .stream()
                .map(appointmentMapper::toAppointmentResponseDto)
                .toList();

        DoctorResponseDto doctorResponseDto = DoctorResponseDto
                .builder()
                .id(doctorEntity.getId())
                .name(doctorEntity.getName())
                .profession(doctorEntity.getProfession())
                .workExperience(doctorEntity.getWorkExperience())
                .appointments(appointmentRequestDtos)
                .build();
        return doctorResponseDto;
    }

    @Autowired
    public void setAppointmentMapper(AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }
}
