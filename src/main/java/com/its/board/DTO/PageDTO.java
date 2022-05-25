package com.its.board.DTO;

import lombok.Data;

@Data
public class PageDTO {
    private int page; //현재페이지
    private int maxPage; //필요한 페이지 개수
    private int startPage; //시작페이지
    private int endPage; //끝페이지 (상황에 따라 end와 max의 개수는 같음)
}
