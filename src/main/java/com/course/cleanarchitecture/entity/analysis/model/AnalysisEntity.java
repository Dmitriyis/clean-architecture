package com.course.cleanarchitecture.entity.analysis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "analysis")
@ToString(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AnalysisEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lead_time")
    private Integer leadTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "recommendations")
    private String recommendations;

    public void updateName(String name) {
        GenerateAnalysisEntity.validateName(name);
        this.name = name;
    }

    public void updateLeadTime(Integer leadTime) {
        GenerateAnalysisEntity.validateLeadTime(leadTime);
        this.leadTime = leadTime;
    }

    public void updatePrice(BigDecimal price) {
        GenerateAnalysisEntity.validatePrice(price);
        this.price = price;
    }

    public void updateRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
