package com.its.board.Controller;

import com.its.board.DTO.BoardDTO;
import com.its.board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    //글쓰기 처리
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boolean saveResult = boardService.save(boardDTO);
        if (saveResult) {
            System.out.println("저장성공");
            return "redirect:/board/findAll";
        } else {
            System.out.println("저장실패");
            return "/boardPages/save-fail";
        }
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        long id = 0;
        List<BoardDTO> boardDTOList = boardService.findAll(id);
        model.addAttribute("boardList", boardDTOList);
        return "/boardPages/list";
    }
    @GetMapping("/detail")
    public String findById(@RequestParam("id") long id, Model model){
        System.out.println("id = " + id + ", model = " + model);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "/detail";
    }
//    @GetMapping("/passwordCheck")
//    public String toUpdate(@ModelAttribute BoardDTO boardDTO){
//        boolean updateResult = boardService.update(boardDTO);
//    }


}