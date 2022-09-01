package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> verifyToken(@RequestBody String idToken) {

        int i = tokenService.tokenVerify(idToken);

        return ResponseEntity.ok(null);
    }
}
