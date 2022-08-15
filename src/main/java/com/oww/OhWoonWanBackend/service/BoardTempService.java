package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.domain.Photo;
import com.oww.OhWoonWanBackend.dto.board.RequestRegisterBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardDto;
import com.oww.OhWoonWanBackend.dto.board.ResponseBoardListDto;
import com.oww.OhWoonWanBackend.dto.file.FileUploadDto;
import com.oww.OhWoonWanBackend.repository.BoardTempRepository;
import com.oww.OhWoonWanBackend.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardTempService {

    private final BoardTempRepository boardTempRepository;
    private final PhotoRepository photoRepository;

    public ResponseBoardListDto getBordList() {
        PageRequest pageRequest = PageRequest.of(1, 1, Sort.Direction.DESC, "createdDate");
        Page<Board> boardList = boardTempRepository.findAll(pageRequest);

        ResponseBoardListDto responseBoardListDto = ResponseBoardListDto.builder()
                .boardDtoList(boardList.getContent().stream()
                        .map(
                                board -> ResponseBoardDto.builder()
                                        .boardId(board.getBoardId())
                                        .content(board.getContent())
                                        .boardType(board.getBoardType())
                                        .createdDate(board.getCreatedDate())
                                        .modifiedDate(board.getModifiedDate())
                                        .build()
                        ).collect(Collectors.toList()))
                .build();

        return responseBoardListDto;
    }

    public ResponseBoardDto getBoard(Long boardId) {
        Board board = boardTempRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("not found board"));

        ResponseBoardDto responseBoardDto = ResponseBoardDto.builder()
                .boardId(board.getBoardId())
                .content(board.getContent())
                .boardType(board.getBoardType())
                .createdDate(board.getCreatedDate())
                .modifiedDate(board.getModifiedDate())
                .build();

        return responseBoardDto;
    }

    public Board createBoard(RequestRegisterBoardDto requestDto, List<FileUploadDto> uploadedImageFileList) {
        Board board = Board.builder()
                .content(requestDto.getContent())
                .boardType(requestDto.getBoardType())
                .build();

        Board savedBoard = boardTempRepository.save(board);

        List<Photo> photoList = uploadedImageFileList.stream().map(
                uploadedImageFile -> Photo.builder()
                        .photoName(uploadedImageFile.getUploadName())
                        .photoPath(uploadedImageFile.getStoreName())
                        .board(savedBoard)
                        .build()
        ).collect(Collectors.toList());

        photoList.forEach(photo -> photoRepository.save(photo));

        board.setPhotoList(photoList);

        return boardTempRepository.save(board);
    }
}
