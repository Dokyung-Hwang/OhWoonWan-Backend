package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByBoard_BoardId(Long boardId);
}
