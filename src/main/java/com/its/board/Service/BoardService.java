package com.its.board.Service;

import com.its.board.DTO.BoardDTO;
import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean write(BoardDTO boardDTO) {
        int writeResult = boardRepository.write(boardDTO);
        if (writeResult > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }
}