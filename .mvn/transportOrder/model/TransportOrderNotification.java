package com.course.cleanarchitecture.entity.transportOrder.model;

import com.course.cleanarchitecture.entity.transportOrder.model.event.TransportOrderNotificationDto;

public interface TransportOrderNotification {
    public void send(TransportOrderNotificationDto jmsNotificationDto);
}
