package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.dto.board.RequestRegisterBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardListDto;
import com.oww.OhWoonWanBackend.dto.file.FileUploadDto;
import com.oww.OhWoonWanBackend.service.BoardService;
import com.oww.OhWoonWanBackend.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final FileUploadService fileUploadService;

    @GetMapping
    public ResponseEntity<?> getBoardList() {
        ResponseBoardListDto responseBoardListDto = boardService.getBordList();

        return ResponseEntity.ok(responseBoardListDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable Long boardId) {
        ResponseBoardDto responseBoardDto = boardService.getBoard(boardId);

        return ResponseEntity.ok(responseBoardDto);
    }
    
    @PostMapping
    public ResponseEntity<?> registerBoard(RequestRegisterBoardDto requestDto) {

        List<FileUploadDto> uploadedImageFileList = fileUploadService.storeFiles(requestDto.getImageFileList());

        Board savedBoard = boardService.createBoard(requestDto, uploadedImageFileList);
        URI location = UriComponentsBuilder.newInstance().path("/board/{id}").buildAndExpand(savedBoard.getBoardId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.noContent().build();
    }
}
