package com.its.board.Service;

import com.its.board.DTO.BoardDTO;
import com.its.board.DTO.PageDTO;
import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean save(BoardDTO boardDTO) {
        int saveResult = boardRepository.save(boardDTO);
        if (saveResult > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<BoardDTO> findAll(long id) {
        return boardRepository.findAll(id);
    }

    public BoardDTO findById(long id) {
        return boardRepository.findById(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }
    public void saveFile(BoardDTO boardDTO) throws IOException {
        /**
         1. DTO 객체에 담긴 파일을 꺼냄.
         2. 파일의 이름을 가져옴.
         2.1. 파일 이름 중복을 피하기 위한 조치
         3. 파일 이름을 DTO 객체의 boardFileName에 저장
         4. 파일의 저장 위치 지정.
         5. 파일 저장처리
         6. DTO 객체 repository로 전달
         */
        MultipartFile boardFile = boardDTO.getBoardFile(); // 1.
        String boardFileName = boardFile.getOriginalFilename(); // 2.
        boardFileName = System.currentTimeMillis() + "-" + boardFileName; // 2.1.
        boardDTO.setBoardFileName(boardFileName); // 3.
        String savePath = "D:\\spring_img\\" + boardFileName; // 4.
        // 5.
        if (!boardFile.isEmpty()) {
            boardFile.transferTo(new File(savePath));
        }
        boardRepository.saveFile(boardDTO); // 6.
    }

    private static final int PAGE_LIMIT = 3; //한페이지에 보여줄 글 갯수
    private static final int BLOCK_LIMIT = 3;

    public List<BoardDTO> pagingList(int page) {
        int pagingStart = (page-1) * PAGE_LIMIT;
        Map<String, Integer> pagingParam = new HashMap<>();
        pagingParam.put("start", pagingStart);
        pagingParam.put("limit", PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParam);
        return pagingList;
    }
    public PageDTO paging(int page) {
        int boardCount = boardRepository.boardCount(); //글 총개수 조회
        int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT)); //maxPage: 필요한 전체 페이지 개수
        // (10개의 글, 3개씩) 10/3=3.3333 =>4
        // DB에저장된 boardCount을 double로 형변환하여 Math.ceil로 올림처리를 한 후 다시 int로 강제 형변환을 함
        //시작페이지는 1 4 7 10번째 글부터 시작
        int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
        // 끝 페이지는 3 6 9 12
        int endPage = startPage + BLOCK_LIMIT - 1;
        if(endPage > maxPage)
            endPage = maxPage;
        //if절에서 실행값이 1줄이라면 중괄호 생략가능.
        //6페이지까지 있다가 글을 삭제해서 최대가 5페이지가 됐다면, end와 max페이지를 동일시켜라.
        PageDTO paging = new PageDTO();
        paging.setPage(page);
        paging.setStartPage(startPage);
        paging.setEndPage(endPage);
        paging.setMaxPage(maxPage);
        return paging;
    }
}