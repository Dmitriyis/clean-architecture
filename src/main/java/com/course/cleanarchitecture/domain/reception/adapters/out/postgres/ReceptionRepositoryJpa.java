package com.course.cleanarchitecture.domain.reception.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReceptionRepositoryJpa extends JpaRepository<ReceptionEntity, UUID>, JpaSpecificationExecutor<ReceptionEntity> {

    @Query(value = "select * from reception r where r.pet_id = :petId", nativeQuery = true)
    List<ReceptionEntity> findAllByPetId(@Param("petId") UUID petId);
}
