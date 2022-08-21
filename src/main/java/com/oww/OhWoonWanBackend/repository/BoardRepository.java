package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
