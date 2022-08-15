package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.dto.board.RequestRegisterBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardListDto;
import com.oww.OhWoonWanBackend.dto.file.FileUploadDto;
import com.oww.OhWoonWanBackend.service.BoardTempService;
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
public class BoardTempController {

    private final BoardTempService boardTempService;
    private final FileUploadService fileUploadService;

    @GetMapping
    public ResponseEntity<?> getBoardList() {
        ResponseBoardListDto responseBoardListDto = boardTempService.getBordList();

        return ResponseEntity.ok(responseBoardListDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable Long boardId) {
        ResponseBoardDto responseBoardDto = boardTempService.getBoard(boardId);

        return ResponseEntity.ok(responseBoardDto);
    }
    
    @PostMapping
    public ResponseEntity<?> registerBoard(RequestRegisterBoardDto requestDto) {

        List<FileUploadDto> uploadedImageFileList = fileUploadService.storeFiles(requestDto.getImageFileList());

        Board savedBoard = boardTempService.createBoard(requestDto, uploadedImageFileList);
        URI location = UriComponentsBuilder.newInstance().path("/board/{id}").buildAndExpand(savedBoard.getBoardId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
