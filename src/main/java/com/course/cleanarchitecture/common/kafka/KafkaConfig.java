package com.course.cleanarchitecture.common.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic receptionTopic() {
        return TopicBuilder.name("create-reception")
                .partitions(3)
                .replicas(1)
                .config("retention.ms", "604800000")
                .build();
    }
}
