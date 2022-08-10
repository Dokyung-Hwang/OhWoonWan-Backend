package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.domain.CommentOf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentOfRepository extends JpaRepository<CommentOf, Long> {

    List<CommentOf> findAllByBoardOf_Id(Long boardOfId);
}
