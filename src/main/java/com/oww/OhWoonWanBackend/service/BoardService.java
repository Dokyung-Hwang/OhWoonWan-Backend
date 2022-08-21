package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.domain.Board;
import com.oww.OhWoonWanBackend.dto.board.RequestBoardDto;
import com.oww.OhWoonWanBackend.dto.board.RequestRegisterBoardDto;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import com.oww.OhWoonWanBackend.repository.BoardRepository;
import com.oww.OhWoonWanBackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final AccountRepository accountRepository;

    // 게시글 조회(id)
    public Board findById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("not found board"));

        return board;
    }

    // 게시글 작성
    public Board save(RequestRegisterBoardDto requestRegisterBoardDto) {
        Account account = accountRepository.findById(requestRegisterBoardDto.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("not found account"));

        Board board = Board.builder()
                .content(requestRegisterBoardDto.getContent())
                .account(account)
                .build();

        return boardRepository.save(board);
    }



    // 게시글 삭제
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

}
