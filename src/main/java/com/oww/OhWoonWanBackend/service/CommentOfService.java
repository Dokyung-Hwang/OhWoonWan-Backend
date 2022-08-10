package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.domain.CommentOf;
import com.oww.OhWoonWanBackend.repository.CommentOfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentOfService {

    private final CommentOfRepository commentOfRepository;

    public List<CommentOf> getCommentList(Long boardOfId) {
        List<CommentOf> commentOfList = commentOfRepository.findAllByBoardOf_Id(boardOfId);

        return commentOfList;
    }
}
