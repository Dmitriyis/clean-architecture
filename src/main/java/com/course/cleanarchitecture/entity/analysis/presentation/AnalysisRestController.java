package com.course.cleanarchitecture.entity.analysis.presentation;

import com.course.cleanarchitecture.entity.analysis.useCase.CreateNewAnalysisUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.DeleteAnalysisByIdUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.GetAnalysisByIdUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.UpdateAnalysisUseCase;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisRequestDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisResponseDto;
import com.course.cleanarchitecture.entity.analysis.useCase.dto.AnalysisUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analysis")
public class AnalysisRestController {

    private final UpdateAnalysisUseCase updateAnalysisUseCase;
    private final GetAnalysisByIdUseCase getAnalysisByIdUseCase;
    private final CreateNewAnalysisUseCase createNewAnalysisUseCase;
    private final DeleteAnalysisByIdUseCase deleteAnalysisByIdUseCase;

    @PostMapping
    public UUID saveAnalysis(@RequestBody AnalysisRequestDto analysisRequestDto) {
        return createNewAnalysisUseCase.execute(analysisRequestDto);
    }

    @GetMapping("/{id}")
    public AnalysisResponseDto getAnalysis(@PathVariable("id") UUID id) {
        return getAnalysisByIdUseCase.execute(id);
    }

    @PutMapping
    public UUID updateAnalysis(@RequestBody AnalysisUpdateDto analysisUpdateDto) {
        return updateAnalysisUseCase.execute(analysisUpdateDto);
    }

    @DeleteMapping("/{id}")
    public UUID deleteAnalysis(@PathVariable("id") UUID id) {
        return deleteAnalysisByIdUseCase.execute(id);
    }
}
