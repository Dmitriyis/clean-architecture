package com.course.cleanarchitecture.domain.transportOrder.model;

import com.course.cleanarchitecture.domain.transportOrder.model.event.TransportOrderNotificationDto;

public interface TransportOrderNotification {
    public void send(TransportOrderNotificationDto jmsNotificationDto);
}
