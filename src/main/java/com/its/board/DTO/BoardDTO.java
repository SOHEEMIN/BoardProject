package com.its.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long boardId;
    private String boardTitle;
    private String boardName;
    private String boardDate;
    private int boardHits;
    private String boardContents;
}
