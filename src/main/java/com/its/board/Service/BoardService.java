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

    public boolean save(BoardDTO boardDTO) {
        int saveResult = boardRepository.save(boardDTO);
        if (saveResult > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<BoardDTO> findAll(long id) {
        return boardRepository.findAll(id);
    }

    public BoardDTO findById(long id) {
        return boardRepository.findById(id);
    }
}