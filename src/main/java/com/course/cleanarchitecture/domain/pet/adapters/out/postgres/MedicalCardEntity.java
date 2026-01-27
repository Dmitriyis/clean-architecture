package com.course.cleanarchitecture.domain.pet.adapters.out.postgres;

import com.course.cleanarchitecture.domain.analysis.adapters.out.postgres.AnalysisEntity;
import com.course.cleanarchitecture.domain.reception.adapters.out.postgres.ReceptionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_card")
public class MedicalCardEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Builder.Default
    @OneToMany(mappedBy = "medicalCard")
    private List<AnalysisEntity> analysis = new ArrayList<>();

    @OneToMany(mappedBy = "medicalCard")
    private List<ReceptionEntity> reception;

    public void setAnalysis(List<AnalysisEntity> analysis) {
        if (analysis != null) {
            analysis.forEach(analysisEntity -> {
                analysisEntity.setMedicalCard(this);
                this.analysis.add(analysisEntity);
            });
        }
    }
}
