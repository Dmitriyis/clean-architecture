package com.course.cleanarchitecture.domain.ownerPet.model;

import com.course.cleanarchitecture.domain.ownerPet.model.valueObject.Address;
import com.course.cleanarchitecture.domain.pet.model.PetEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Table(name = "owner_pet")
@ToString(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class OwnerPetEntity {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "ownerPet")
    List<PetEntity> pets = new ArrayList<>();

    public void updateName(String name) {
        GenerateOwnerPetEntity.validateName(name);
        this.name = name;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }
}
