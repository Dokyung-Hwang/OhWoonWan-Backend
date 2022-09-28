package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.common.type.Role;
import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.dto.account.RequestNicknameDto;
import com.oww.OhWoonWanBackend.dto.account.RequestRegisterAccountDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccount(RequestRegisterAccountDto requestDto) {

        Account account = Account.builder()
                .username(requestDto.getName())
                .email(requestDto.getEmail())
                .role(Role.SOCIAL)
                .build();

        return accountRepository.save(account);
    }

    @Transactional
    public Account savedNickname(Long accountId, RequestNicknameDto requestNicknameDto) throws Exception {
        Account getAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("not found account"));

/*
        if (getAccount.getNickname() != null) {
            throw new IllegalStateException("nickname exists");
        }
*/

        if (!getAccount.getAccountId().equals(requestNicknameDto.getAccountId()) || !getAccount.getEmail().equals(requestNicknameDto.getEmail()))
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));
        else
            getAccount.update(requestNicknameDto.getNickname(), requestNicknameDto.getRole());

        return getAccount;
    }
}
