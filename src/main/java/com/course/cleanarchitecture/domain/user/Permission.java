package com.course.cleanarchitecture.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "permission")
public class Permission {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "permission")
    private String permission;
}
