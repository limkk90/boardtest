package org.zerock.boardtest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.boardtest.dto.ReplyDTO;
import org.zerock.boardtest.dto.boardDTO;
import org.zerock.boardtest.service.*;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
public class HomeController {
    @Autowired
    MainServiceImpl mainServiceImpl;
    @Autowired
    ReplyServiceImpl replyServiceImpl;

    String modiB_dtt;
    String modiPage;
    String modiJoin;

//    @PostMapping("/list")
//    public String search(){
//
//        return "redirect:/board/list";
//    }
    @GetMapping("/list")
    public String showMain(Criteria criteria, Model model,
                           @RequestParam(defaultValue = "1") int page){
        List<boardDTO> boardDto = null;
        log.info("서치키워드:"+ criteria.getKeyWord());
        log.info("서치카테고리:"+ criteria.getSer());
        Pagination pagination = new Pagination(mainServiceImpl.boardListCnt(), page, 10);
//      log.info("페이지네이션:"+ pagination);
        criteria.setPage(pagination.getPage());
        log.info("setPage크리테리아1:"+ criteria);
        if(criteria.getSer() == 'T'){
            boardDto = mainServiceImpl.getBoardListSearchTitle(criteria);
        }
        if(criteria.getSer() == 'W'){
            boardDto = mainServiceImpl.getBoardListSearchWriter(criteria);
        }
        if(criteria.getSer() == 0) {
            boardDto = mainServiceImpl.getBoardList(criteria);
        }
//        log.info("setPage크리테리아2:"+ criteria.getPage());
//        log.info("겟리스트:"+ mainServiceImpl.getBoardList());
        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardDto);

        return "/board/list";
    }



    @GetMapping("/register")
    public void register(){
        log.info("등록 겟매핑");
    }

    @PostMapping("/register")
    public String register(boardDTO boardDTO, @RequestParam char select){
//        log.info("레지스터셀렉트옵션:"+ select);
//        log.info("레지스터DTO:"+boardDTO);
        boardDTO.setCat_cd(select);
        mainServiceImpl.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(String cat_cd, String b_dtt, String page, Model model, Criteria criteria, String join){
//        log.info("리드실행됨:"+b_dtt);
//        log.info("리드실행됨:"+ page);
//        log.info("리드실행됨:"+ join);
        modiB_dtt = b_dtt;
        modiPage = page;
        modiJoin = join;

//        log.info("리드 실행됨3크리테리아:"+ criteria.getPage());
        boardDTO dto = mainServiceImpl.read(b_dtt);
//        log.info("readDTO:" + dto);
//        log.info("read리플라이 리스트1:"+ join);
        List<ReplyDTO> reply = replyServiceImpl.getReplyList(join);
//        log.info("read리플라이 리스트:"+ reply);
        model.addAttribute("dto", dto);
        model.addAttribute("page", criteria);
        model.addAttribute("replyList", reply);
    }

    @PostMapping("/modify")
    public String modify(boardDTO boardDTO){
//        log.info("게시글 수정:"+ modiB_dtt);
//        log.info("게시글 수정:"+ modiPage);
//        log.info("게시글 수정:"+ modiJoin);
//        log.info("게시글 수정:"+ boardDTO.getCat_cd());
//        log.info("게시글 수정 제목:"+boardDTO.getB_title());
//        log.info("게시글 수정 내용:"+boardDTO.getB_content());
        mainServiceImpl.update(boardDTO.getB_title(),boardDTO.getB_content(), modiB_dtt);
        return "redirect:/board/read?b_dtt=" + modiB_dtt + "&page=" + modiPage + "&join=" + modiJoin;
    }

    @PostMapping("/remove")
    public String remove(String b_dtt, String page){
//        log.info("게시글삭제");
//        log.info("삭제주소값:"+ b_dtt);
//        log.info("삭제페이지:"+ page);
        mainServiceImpl.delete(b_dtt);
        return "redirect:/board/list?page="+ page;
    }
}
