package com.its.board.Repository;

import com.its.board.DTO.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int write(BoardDTO boardDTO) {
        return sql.insert("Board.write", boardDTO);

    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }
}
