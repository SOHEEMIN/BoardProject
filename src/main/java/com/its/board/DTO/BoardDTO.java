package com.its.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long id;
    private String boardTitle;
    private String boardWriter;
    private String boardPassword;
    private String boardContents;
    private int boardHits;
    private String boardCreatedDate;
}
