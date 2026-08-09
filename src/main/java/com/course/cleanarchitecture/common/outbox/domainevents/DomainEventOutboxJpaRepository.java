package com.course.cleanarchitecture.common.outbox.domainevents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DomainEventOutboxJpaRepository extends JpaRepository<DomainEventOutbox, UUID> {

    @Query(value = "select * from domain_event_outbox where (status is null or status != 'FAILED')" +
            " and processed_on_utc is null", nativeQuery = true)
    List<DomainEventOutbox> findUnprocessedMessages();
}
