package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.common.type.Role;
import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.dto.account.RequestRegisterAccountDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;


    /*@Transactional
    public Long join(AccountDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));

        return accountRepository.save(dto.toEntity()).getAccountId();
    }*/


    public Account createAccount(RequestRegisterAccountDto requestDto) {

        Account account = Account.builder()
                .username(requestDto.getName())
                .email(requestDto.getEmail())
                .role(Role.SOCIAL)
                .build();

        Account savedAccount = accountRepository.save(account);

        return savedAccount;
    }
}
