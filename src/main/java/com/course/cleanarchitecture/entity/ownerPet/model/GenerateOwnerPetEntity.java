package com.course.cleanarchitecture.entity.ownerPet.model;

import com.course.cleanarchitecture.common.extensionsCollections.ListCommon;
import com.course.cleanarchitecture.entity.ownerPet.exceptions.OwnerPetInvalidFieldException;
import com.course.cleanarchitecture.entity.ownerPet.model.valueObject.Address;

import java.time.LocalDate;
import java.util.UUID;

public class GenerateOwnerPetEntity {

    public static OwnerPetEntity generate(UUID id, String name, LocalDate registrationDate, Address address) {
        validateField(id, name, registrationDate);

        return new OwnerPetEntity(id, name, registrationDate, address, ListCommon.of());
    }

    public static void validateField(UUID id, String name, LocalDate registrationDate) {
        validateId(id);
        validateName(name);
        validateRegistrationDate(registrationDate);
    }

    public static void validateId(UUID id) {
        if (id == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("id", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }
    }

    public static void validateName(String name) {
        if (name == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("name", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (name.isEmpty()) {
            String message = OwnerPetInvalidFieldException.prepareMessage("name", "", "Не можеть быть empty");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (name.length() > 10) {
            String message = OwnerPetInvalidFieldException.prepareMessage("name", name, "Не можеть быть больше 10 символов");
            throw new OwnerPetInvalidFieldException(message);
        }
    }

    public static void validateRegistrationDate(LocalDate registrationDate) {
        if (registrationDate == null) {
            String message = OwnerPetInvalidFieldException.prepareMessage("registrationDate", null, "Не можеть быть null");
            throw new OwnerPetInvalidFieldException(message);
        }

        if (registrationDate.isBefore(LocalDate.now())) {
            String message = OwnerPetInvalidFieldException.prepareMessage("registrationDate", registrationDate, "Не может быть раньше текущей даты");
            throw new OwnerPetInvalidFieldException(message);
        }
    }
}
