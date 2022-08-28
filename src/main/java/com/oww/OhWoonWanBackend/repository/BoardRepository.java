package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.common.type.BoardType;
import com.oww.OhWoonWanBackend.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {
    @Override
    Page<Board> findAll(Pageable pageable);

    Page<Board> findBoardsByBoardType(String boardType, Pageable pageable);

    Page<Board> findBoardsByBoardTypeAndBoardIdLessThan(BoardType boardType, Long lastBoardId, Pageable pageable);
}
