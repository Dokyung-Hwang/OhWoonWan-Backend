package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.domain.Comment;
import com.oww.OhWoonWanBackend.dto.comment.RequestRegisterCommentDto;
import com.oww.OhWoonWanBackend.dto.comment.ResponseCommentDto;
import com.oww.OhWoonWanBackend.dto.comment.ResponseCommentListDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import com.oww.OhWoonWanBackend.repository.BoardRepository;
import com.oww.OhWoonWanBackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final AccountRepository accountRepository;
    private final BoardRepository boardRepository;

    public ResponseCommentListDto getCommentList(Long boardId) {
        List<Comment> commentList = commentRepository.findCommentsByBoard_BoardId(boardId);

        ResponseCommentListDto responseCommentListDto = ResponseCommentListDto.builder()
                .commentDtoList(commentList.stream().map(
                        comment -> ResponseCommentDto.builder()
                                .id(comment.getCommentId())
                                .nickname(comment.getAccount().getNickname())
                                .content(comment.getContent())
                                .modifiedDate(comment.getModifiedDate())
                                .createdDate(comment.getCreatedDate())
                                .build()
                ).collect(Collectors.toList()))
                .build();

        return responseCommentListDto;
    }

    public Comment create(RequestRegisterCommentDto requestDto) {
        Account account = accountRepository.findById(requestDto.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("not found account"));

        Board board = boardRepository.findById(requestDto.getBoardId())
                .orElseThrow(() -> new EntityNotFoundException("not found board"));

        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .account(account)
                .board(board)
                .build();

        Comment savedComment = commentRepository.save(comment);

        return savedComment;
    }
}
