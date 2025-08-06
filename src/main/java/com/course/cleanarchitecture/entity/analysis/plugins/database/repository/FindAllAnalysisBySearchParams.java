package com.course.cleanarchitecture.entity.analysis.plugins.database.repository;

import com.course.cleanarchitecture.entity.analysis.model.AnalysisEntity;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisSearchParamsDto;
import com.course.cleanarchitecture.entity.analysis.useCase.provider.FindAllAnalysisBySearchParamsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindAllAnalysisBySearchParams implements FindAllAnalysisBySearchParamsProvider {

    private final AnalysisRepositoryJpa analysisRepositoryJpa;

    @Override
    public List<AnalysisEntity> execute(AnalysisSearchParamsDto analysisSearchParamsDto) {
        AnalysisSearchParamsSpecification analysisSearchParamsSpecification = toAnalysisSearchParamsSpecification(analysisSearchParamsDto);
        return analysisRepositoryJpa.findAll(analysisSearchParamsSpecification);
    }

    public AnalysisSearchParamsSpecification toAnalysisSearchParamsSpecification(AnalysisSearchParamsDto analysisSearchParamsDto) {
        return AnalysisSearchParamsSpecification
                .builder()
                .id(analysisSearchParamsDto.getId())
                .name(analysisSearchParamsDto.getName())
                .leadTime(analysisSearchParamsDto.getLeadTime())
                .recommendations(analysisSearchParamsDto.getRecommendations())
                .build();
    }
}
