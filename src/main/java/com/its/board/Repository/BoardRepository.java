package com.its.board.Repository;

import com.its.board.DTO.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.write", boardDTO);

    }

    public List<BoardDTO> findAll(long id) {
        sql.update("Board.updateHits", id);
        return sql.selectList("Board.findAll");
    }


    public BoardDTO findById(long id) {
        sql.update("Board.updateHits", id);
        return sql.selectOne("Board.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void saveFile(BoardDTO boardDTO) {
        sql.insert("Board.saveFile", boardDTO);
    }

}

