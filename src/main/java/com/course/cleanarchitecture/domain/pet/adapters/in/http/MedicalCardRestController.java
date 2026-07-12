package com.course.cleanarchitecture.domain.pet.adapters.in.http;

import com.course.cleanarchitecture.domain.pet.core.ports.PetRepository;
import com.course.cleanarchitecture.domain.reception.adapters.in.http.dto.ReceptionCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(MedicalCardConstantsHttp.URL_ROOT)
public class MedicalCardRestController {

    private final PetRepository petRepository;

    public UUID updateMedicalCard(@RequestBody ReceptionCreate receptionCreate, @RequestParam UUID id) {


        return null;
    }
}

