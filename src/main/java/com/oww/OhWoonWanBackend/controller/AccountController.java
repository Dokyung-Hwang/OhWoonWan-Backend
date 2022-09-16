package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.dto.account.RequestNicknameDto;
import com.oww.OhWoonWanBackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;


    @PutMapping("/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable Long accountId, @RequestBody RequestNicknameDto requestNicknameDto) {
        Account savedAccount = accountService.savedNickname(accountId, requestNicknameDto);

        URI location = UriComponentsBuilder
                .newInstance()
                .path("/account/{id}").buildAndExpand(savedAccount.getAccountId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
