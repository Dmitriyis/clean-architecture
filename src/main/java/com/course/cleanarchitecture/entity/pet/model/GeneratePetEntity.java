package com.course.cleanarchitecture.entity.pet.model;

import com.course.cleanarchitecture.entity.ownerPet.model.OwnerPetEntity;
import com.course.cleanarchitecture.entity.pet.exceptions.PetInvalidFieldException;

import java.time.LocalDate;
import java.util.UUID;

public class GeneratePetEntity {

    public static PetEntity generate(UUID id, String name, Double weight, Integer age, LocalDate registrationDate, UUID ownerPetId) {

        validateField(id, name, weight, age, registrationDate, ownerPetId);

        OwnerPetEntity ownerPetEntity = new OwnerPetEntity(ownerPetId, null, null, null, null);

        return new PetEntity(id, name, weight, age, registrationDate, ownerPetEntity, null);
    }

    private static void validateField(UUID id, String name, Double weight, Integer age, LocalDate registrationDate, UUID ownerPetId) {
        validateId(id);
        validateName(name);
        validateWeight(weight);
        validateAge(age);
        validateRegistrationDate(registrationDate);
        validateOwnerPetId(ownerPetId);
    }

    public static void validateId(UUID id) {
        if (id == null) {
            String message = PetInvalidFieldException.prepareMessage("id", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }
    }

    public static void validateOwnerPetId(UUID id) {
        if (id == null) {
            String message = PetInvalidFieldException.prepareMessage("ownerPetId", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }
    }

    public static void validateName(String name) {
        if (name == null) {
            String message = PetInvalidFieldException.prepareMessage("name", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }

        if (name.isEmpty()) {
            String message = PetInvalidFieldException.prepareMessage("name", "", "Не можеть быть empty");
            throw new PetInvalidFieldException(message);
        }

        if (name.length() > 10) {
            String message = PetInvalidFieldException.prepareMessage("name", name, "Не можеть быть больше 10 символов");
            throw new PetInvalidFieldException(message);
        }
    }

    public static void validateWeight(Double weight) {
        if (weight == null) {
            String message = PetInvalidFieldException.prepareMessage("weight", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }

        if (weight < 1) {
            String message = PetInvalidFieldException.prepareMessage("weight", weight, "Не можеть быть меньше 0");
            throw new PetInvalidFieldException(message);
        }
    }

    public static void validateAge(Integer age) {
        if (age == null) {
            String message = PetInvalidFieldException.prepareMessage("age", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }

        if (age < 1) {
            String message = PetInvalidFieldException.prepareMessage("age", age, "Не можеть быть меньше 1");
            throw new PetInvalidFieldException(message);
        }
    }

    public static void validateRegistrationDate(LocalDate registrationDate) {
        if (registrationDate == null) {
            String message = PetInvalidFieldException.prepareMessage("registrationDate", null, "Не можеть быть null");
            throw new PetInvalidFieldException(message);
        }

        if (registrationDate.isBefore(LocalDate.now())) {
            String message = PetInvalidFieldException.prepareMessage("registrationDate", registrationDate, "Не может быть раньше текущей даты");
            throw new PetInvalidFieldException(message);
        }
    }
}
