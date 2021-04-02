package org.zerock.boardtest.service;

import org.zerock.boardtest.dto.boardDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface MainService {
        List<boardDTO> getBoardList(Criteria criteria); // 게시판 리스트
        List<boardDTO> getBoardListSearchTitle(Criteria criteria); //제목검색 게시판
        List<boardDTO> getBoardListSearchWriter(Criteria criteria); // 작성자검색 게시판
        void register(boardDTO boardDTO); //글 등록
        boardDTO read(String time);  //글 조회
        void update(String title,String content ,String time); // 글 수정
        void delete(String time); //글 삭제
}
