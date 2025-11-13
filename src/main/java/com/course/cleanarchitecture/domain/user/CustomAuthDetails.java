package com.course.cleanarchitecture.domain.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

@Getter
public class CustomAuthDetails extends WebAuthenticationDetails {
    private String userType;

    public CustomAuthDetails(HttpServletRequest request, String userType) {
        super(request);
        this.userType = userType;
    }
}
