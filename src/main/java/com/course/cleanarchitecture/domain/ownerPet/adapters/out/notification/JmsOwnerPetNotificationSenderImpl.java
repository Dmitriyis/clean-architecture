package com.course.cleanarchitecture.domain.ownerPet.adapters.out.notification;

import com.course.cleanarchitecture.domain.ownerPet.core.ports.OwnerPetNotificationSender;
import org.springframework.stereotype.Service;

@Service
public class JmsOwnerPetNotificationSenderImpl implements OwnerPetNotificationSender {

    @Override
    public void send(String message, String phone) {
        System.out.println("Send message.");
        System.out.println("Message:" + message + ".");
    }
}
