package com.webgram.web;

import com.webgram.entity.User;
import com.webgram.pojo.AuthReponse;
import com.webgram.pojo.LoginRequest;
import com.webgram.service.ImplementCategorie.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/webgram/v1/auth")
@CrossOrigin
public class AuthentificationController {
    private final AuthServiceImpl authService;
    @PostMapping("/register")
    public ResponseEntity <User>
    register(@RequestBody User user) {
        return ResponseEntity.status(
                HttpStatus.CREATED).body(
                        authService.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity <AuthReponse> loginRequest(@RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.login(request));
    }
}
