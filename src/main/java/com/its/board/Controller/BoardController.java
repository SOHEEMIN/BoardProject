package com.its.board.Controller;

import com.its.board.DTO.BoardDTO;
import com.its.board.DTO.CommentDTO;
import com.its.board.DTO.PageDTO;
import com.its.board.Service.BoardService;
import com.its.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

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
    public String findAll(Model model) {
        long id = 0;
        List<BoardDTO> boardDTOList = boardService.findAll(id);
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/list";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") long id, Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        System.out.println("id = " + id + ", model = " + model);
//        BoardDTO boardDTO = boardService.findById(id); 아래처럼도 사용 가능
        model.addAttribute("board",  boardService.findById(id));
        model.addAttribute("page", page);
        //댓글 목록도 가져가야 함.
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        return "boardPages/detail";
    }

    // 비밀번호 체크 페이지
    @GetMapping("/passwordCheck")
    public String passwordCheck(@RequestParam("id") long id, Model model) {
//        BoardDTO boardDTO = boardService.findById(id); 아래처럼도 가능
        model.addAttribute("board", boardService.findById(id));
        return "boardPages/passwordCheck";
    }

    // 삭제 처리
    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        boardService.delete(id);
        return "redirect:/board/findAll";
    }
    //수정화면요청 (수정은 총 2번임. 수정화면출력 한번, 수정완료 디비 저장 보내기 두번)
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") long id, Model model){
        BoardDTO boardDTO = boardService.findById((id));
        model.addAttribute("boardUpdate", boardDTO);
        return "boardPages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO){
        boardService.update(boardDTO);
        return "redirect:/board/detail?id="+boardDTO.getId();
    }
    // 글작성화면(파일)
    @GetMapping("/saveFile")
    public String saveFileForm(){
        return "boardPages/saveFile";
    }

    //파일첨부 글작성 처리
    @PostMapping("/saveFile")
    public String saveFile(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.saveFile(boardDTO);
        return "redirect:/board/findAll";
    }
    @GetMapping("/paging")
    // /board/paging?page=1
    // required=false 하면 /board/paging 요청도 가능하다.
    // 별도의 페이지 값을 요청하지 않으면 페이지(page=1)를 보여주자.
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        // ↑해당 페이지에 보여져야하는 글 리스트
        PageDTO paging = boardService.paging(page);
        // ↑페이지 하단에 보여져야하는 글 번호
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "boardPages/pagingList";
    }

    //검색처리
    @GetMapping("/search")
    public String search(@RequestParam("searchType") String searchType,@RequestParam ("q") String q, Model model){
        List<BoardDTO> searchList = boardService.search(searchType,q);
        model.addAttribute("boardList", searchList);
        return "boardPages/list";
    }
}