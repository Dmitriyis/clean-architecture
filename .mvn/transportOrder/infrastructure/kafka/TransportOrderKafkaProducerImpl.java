package com.course.cleanarchitecture.domain.transportOrder.infrastructure.kafka;

import com.course.cleanarchitecture.domain.transportOrder.model.TransportOrderNotification;
import com.course.cleanarchitecture.domain.transportOrder.model.event.TransportOrderNotificationDto;

public class TransportOrderKafkaProducerImpl implements TransportOrderNotification {
    @Override
    public void send(TransportOrderNotificationDto jmsNotificationDto) {

    }
}
