package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.dto.board.RequestRegisterBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardDto;
import com.oww.OhWoonWanBackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 게시판 조회(ID)
    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable Long boardId) {
        Board board = boardService.findById(boardId);

        ResponseBoardDto responseBoardDto = ResponseBoardDto.builder()
                .content(board.getContent())
                .nickname(board.getAccount().getNickname())
                .build();

        return ResponseEntity.ok(responseBoardDto);
    }


    // 게시판 추가
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody RequestRegisterBoardDto requestDto) {
        Board savedBoard = boardService.save(requestDto);
        URI location = UriComponentsBuilder.newInstance().path("/board/{id}").buildAndExpand(savedBoard.getBoardId()).toUri();
        return ResponseEntity.created(location).build();
    }


    // 게시판 삭제
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.noContent().build();
    }
}
