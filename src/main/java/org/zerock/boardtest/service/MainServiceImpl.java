package org.zerock.boardtest.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.boardtest.dto.boardDTO;
import org.zerock.boardtest.mapper.MainMapper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MainServiceImpl implements MainService {

    @Autowired(required = false)
    MainMapper mainMapper;

    @Override
    public List<boardDTO> getBoardList(Criteria criteria) {
        log.info("겟보드 리스트:" + mainMapper);
        List<boardDTO> boardlist = mainMapper.getBoardList(criteria);
        log.info("겟보드 리스트:" + boardlist);
        return boardlist;
    }

    @Override
    public List<boardDTO> getBoardListSearchTitle(Criteria criteria) {
        return mainMapper.getBoardListSearchTitle(criteria);
    }

    @Override
    public List<boardDTO> getBoardListSearchWriter(Criteria criteria) {
        return mainMapper.getBoardListSearchWriter(criteria);
    }

    @Override
    public void register(boardDTO boardDTO) {
        log.info("ServiceImpl-레지스터DTO:" + boardDTO);
        mainMapper.insertBoard(boardDTO);
    }

    @Override
    public boardDTO read(String time) {
        log.info("ImplREAD들어옴"+time);
        log.info("ImplReadDTO:"+mainMapper.getBoard(time));
        return mainMapper.getBoard(time);
    }

    @Override
    public void update(String title, String content, String time) {
        log.info("ServiceImpl-업데이트:" + title);
        log.info("ServiceImpl-업데이트:" + content);
        log.info("ServiceImpl-업데이트:" + time);
        mainMapper.updateBoard(title, content, time);
    }

    @Override
    public void delete(String time) {
        log.info("IMPL딜리트");
        log.info("IMPL딜리트:"+time);
        mainMapper.deleteBoard(time);
    }

    public int boardListCnt(){
        return mainMapper.boardListCnt();
    }
}
