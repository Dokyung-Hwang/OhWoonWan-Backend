package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // OAuth
    Optional<Account> findByEmail(String email);
}
