package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.Comment;
import com.oww.OhWoonWanBackend.dto.comment.RequestRegisterCommentDto;
import com.oww.OhWoonWanBackend.dto.comment.ResponseCommentListDto;
import com.oww.OhWoonWanBackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getCommentByBoardId(@PathVariable Long boardId) {
        ResponseCommentListDto responseCommentListDto = commentService.getCommentList(boardId);

        return ResponseEntity.ok(responseCommentListDto);
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody RequestRegisterCommentDto requestDto) {
        Comment savedComment = commentService.create(requestDto);
        URI location = UriComponentsBuilder.newInstance().path("/comment/{id}").buildAndExpand(savedComment.getCommentId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
