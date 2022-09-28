package com.oww.OhWoonWanBackend.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.dto.account.RequestRegisterAccountDto;
import com.oww.OhWoonWanBackend.dto.account.ResponseAccountIdDto;
import com.oww.OhWoonWanBackend.dto.token.RequestRegisterTokenDto;
import com.oww.OhWoonWanBackend.service.AccountService;
import com.oww.OhWoonWanBackend.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.SecretKey;
import java.net.URI;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/token")
public class TokenController {

    private final TokenService tokenService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RequestRegisterTokenDto requestDto) {
        GoogleIdToken googleIdToken = tokenService.tokenVerify(requestDto.getIdToken());
        JwtBuilder builder = Jwts.builder();

        // Header
        builder.setHeaderParam("typ", "JWT");

        // Payload
        // Registered Claim
        builder.setIssuer("ohwoonwan");             // token 발급자
        builder.setSubject("JWTToken");                   // token 제목
        builder.setExpiration(new Date(System.currentTimeMillis() + (100 * 60 * 5)));       // token 만료 시간
        builder.setIssuedAt(new Date());        // token 발급 시간


        // Signature
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String secretKey = Encoders.BASE64URL.encode(key.getEncoded());
        SecretKey finalKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));

        builder.signWith(finalKey);

        System.out.println("key: " + key);
        System.out.println("secret string: " + secretKey);
        System.out.println("final key: " + finalKey);
        System.out.println("jws: " + builder.compact());

        RequestRegisterAccountDto requestRegisterAccountDto = RequestRegisterAccountDto.builder()
                .name((String) googleIdToken.getPayload().get("name"))
                .email(googleIdToken.getPayload().getEmail())
                .build();


        Account savedAccount = accountService.createAccount(requestRegisterAccountDto);

        ResponseAccountIdDto responseAccountIdDto = ResponseAccountIdDto.builder()
                .accountId(savedAccount.getAccountId())
                .build();

        URI location = UriComponentsBuilder
                .newInstance()
                .path("/token/{id}")
                .buildAndExpand(savedAccount.getAccountId())
                .toUri();

        return ResponseEntity.created(location).body(responseAccountIdDto);
    }
}
