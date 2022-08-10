package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.CommentOf;
import com.oww.OhWoonWanBackend.dto.commentof.ResponseCommentOfDto;
import com.oww.OhWoonWanBackend.dto.commentof.ResponseCommentOfListDto;
import com.oww.OhWoonWanBackend.service.CommentOfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentOfController {

    private final CommentOfService commentOfService;

    @GetMapping("/{boardOfId}")
    public ResponseEntity<List<CommentOf>> getCommentByBoardOfId(@PathVariable Long boardOfId) {
        List<CommentOf> commentOfList = commentOfService.getCommentList(boardOfId);

/*        ResponseEntity.ok(ResponseCommentOfListDto.builder()
                        .commentOfDtoList(commentOfList.stream().map(
                                commentOf -> ResponseCommentOfDto.builder()
                                        .id(commentOf.getId())
                                        .content(commentOf.getContent())
                                        .createdDate(commentOf.getCreatedDate())
                                        .modifiedDate(commentOf.getModifiedDate())
                                        .build()
                        ))
                .build());*/

        for (CommentOf commentOf : commentOfList) {
            System.out.println("commentOf = " + commentOf);
        }

        return ResponseEntity.ok(commentOfList);
    }
}
