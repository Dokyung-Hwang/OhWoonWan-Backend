package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.common.type.Role;
import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.dto.account.RequestNicknameDto;
import com.oww.OhWoonWanBackend.dto.account.RequestRegisterAccountDto;
import com.oww.OhWoonWanBackend.dto.account.ResponseAccountDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

        Account savedAccount = accountRepository.save(account);

        return savedAccount;
    }

    public Account savedNickname(Long accountId, RequestNicknameDto requestNicknameDto) {
        Account getAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("not found account"));

        if (!getAccount.getNickname().isEmpty()){
            throw new EntityNotFoundException("not found nickname");
        }

        Account account = Account.builder()
                .nickname(requestNicknameDto.getNickname())
                .build();

        Account updateAccount = accountRepository.save(account);
        return updateAccount;
    }
}
