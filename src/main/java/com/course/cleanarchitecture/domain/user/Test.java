package com.course.cleanarchitecture.domain.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

    @PreAuthorize("hasPermission('PATIENT', 'GET')")
    @GetMapping
    public String test() {
        return "IK";
    }

}
