package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTempRepository extends JpaRepository<Board, Long> {

}
