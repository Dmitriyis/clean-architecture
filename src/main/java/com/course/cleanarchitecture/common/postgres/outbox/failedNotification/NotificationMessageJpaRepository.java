package com.course.cleanarchitecture.common.postgres.outbox.failedNotification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationMessageJpaRepository extends JpaRepository<NotificationMessageOutbox, UUID> {
}
