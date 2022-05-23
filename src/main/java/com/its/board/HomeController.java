package com.its.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    //글쓰기화면요청
    @GetMapping("/board/save")
    public String saveForm(){
        return "boardPages/save";
    }

}
