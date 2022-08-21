package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.dto.account.AccountDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder encoder;

    /*@Transactional
    public Long join(AccountDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));

        return accountRepository.save(dto.toEntity()).getAccountId();
    }*/
}
