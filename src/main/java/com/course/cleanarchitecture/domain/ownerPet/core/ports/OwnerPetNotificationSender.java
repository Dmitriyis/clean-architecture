package com.course.cleanarchitecture.domain.ownerPet.core.ports;

public interface OwnerPetNotificationSender {
    void send(String message, String phone);
}
