package com.course.cleanarchitecture.entity.doctor.model;

import com.course.cleanarchitecture.common.exceptions.InvalidFieldException;
import com.course.cleanarchitecture.common.extensionsCollections.ListCommon;
import com.course.cleanarchitecture.entity.doctor.exceptions.DoctorInvalidFieldException;

import java.util.UUID;

public class GenerateDoctorEntity {
    public static DoctorEntity generate(UUID id, String name, TypeProfession profession, Integer workExperience) {
        validateField(id, name, workExperience);
        DoctorEntity doctorEntity = new DoctorEntity(id, name, profession, workExperience, ListCommon.of());
        return doctorEntity;
    }

    private static void validateField(UUID id, String name, Integer workExperience) {
        validateId(id);
        validateName(name);
        validateWorkExperience(workExperience);
    }

    public static void validateId(UUID id) {
        if (id == null) {
            String message = InvalidFieldException.prepareMessage("id", null, "id не может быть null");
            throw new DoctorInvalidFieldException(message);
        }
    }

    public static void validateName(String name) {
        if (name == null) {
            String message = InvalidFieldException.prepareMessage("name", null, "name не может быть null");
            throw new DoctorInvalidFieldException(message);
        }

        if (name.isEmpty()) {
            String message = InvalidFieldException.prepareMessage("name", "", "name не может быть empty");
            throw new DoctorInvalidFieldException(message);
        }
    }

    public static void validateWorkExperience(Integer workExperience) {
        if (workExperience == null) {
            String message = InvalidFieldException.prepareMessage("workExperience", null, "workExperience не может быть null");
            throw new DoctorInvalidFieldException(message);
        }

        if (workExperience < 0) {
            String message = InvalidFieldException.prepareMessage("workExperience", null, "workExperience не может быть меньше 0");
            throw new DoctorInvalidFieldException(message);
        }
    }
}
