package com.course.cleanarchitecture.entity.transportOrder.infrastructure.kafka;

import com.course.cleanarchitecture.entity.transportOrder.model.TransportOrderNotification;
import com.course.cleanarchitecture.entity.transportOrder.model.event.TransportOrderNotificationDto;

public class TransportOrderKafkaProducerImpl implements TransportOrderNotification {
    @Override
    public void send(TransportOrderNotificationDto jmsNotificationDto) {

    }
}
