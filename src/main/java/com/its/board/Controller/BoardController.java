package com.its.board.Controller;

import com.its.board.DTO.BoardDTO;
import com.its.board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/write")
    public String write(@ModelAttribute BoardDTO boardDTO) {
        boolean writeResult = boardService.write(boardDTO);
        if (writeResult) {
            System.out.println("저장성공");
            return "write";
        } else {
            System.out.println("저장실패");
            return "write";
        }
    }
    @PostMapping
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }


}