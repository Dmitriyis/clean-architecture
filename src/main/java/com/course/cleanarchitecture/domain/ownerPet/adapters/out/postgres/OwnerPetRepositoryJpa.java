package com.course.cleanarchitecture.domain.ownerPet.adapters.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerPetRepositoryJpa extends JpaRepository<OwnerPetEntity, UUID>, JpaSpecificationExecutor<OwnerPetEntity> {
    @Query(value = "select op.phone from owner_pet op" +
            " left join pet p on op.id = p.owner_id" +
            " where p.id = :id", nativeQuery = true)
    Optional<String> findOwnerPetPhoneByPetId(UUID id);

    boolean existsById(UUID id);
}
