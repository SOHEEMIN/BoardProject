package com.its.board.DTO;

import lombok.Data;

@Data
public class CommentDTO {
   private Long id;
   private  String commentWriter;
   private  String commentContents;
   private  Long boardId;
   private String commentCreatedDate;
}
