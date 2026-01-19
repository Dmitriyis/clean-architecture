package com.course.cleanarchitecture.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/login")
public class UserController {

    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String loginUser(@RequestBody UserLoginDto userLoginDto) {
        UserDetails userDetails = userService.loadUserByUsername(userLoginDto.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword());
        authenticationManager.authenticate(authentication);

        String token = jwtUtil.generateToken(userDetails);
        return token;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class UserLoginDto {
        private String username;
        private String password;
    }
}
