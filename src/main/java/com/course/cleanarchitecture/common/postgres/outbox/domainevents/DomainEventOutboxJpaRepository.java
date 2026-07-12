package com.course.cleanarchitecture.common.postgres.outbox.domainevents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DomainEventOutboxJpaRepository extends JpaRepository<MessageDomainEventOutbox, UUID> {

    @Query(value =
            "select " +
                    "id," +
                    " event_type," +
                    " aggregate_id," +
                    " aggregate_type," +
                    " payload," +
                    " occurred_on_utc," +
                    " processed_on_utc" +
                    " from outbox " +
                    "where processed_on_utc is null", nativeQuery = true)
    List<MessageDomainEventOutbox> findUnprocessedMessages();
}
