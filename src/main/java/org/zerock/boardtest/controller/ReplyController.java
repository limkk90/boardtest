package org.zerock.boardtest.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.boardtest.dto.ReplyDTO;
import org.zerock.boardtest.dto.boardDTO;
import org.zerock.boardtest.service.Criteria;
import org.zerock.boardtest.service.ReplyServiceImpl;

import javax.print.attribute.standard.Media;
import java.awt.*;


@Controller
@Log4j2
@RequestMapping("/replies")
public class ReplyController {

    String modiR_dtt;
    @Autowired
    ReplyServiceImpl replyServiceImpl;
    static String bDate;

    @PostMapping("regist")
    public String replyRegister(ReplyDTO replyDTO, Criteria criteria, String b_dtt, String page){
//        log.info("포스트매핑 리플라이 레지스트 실행됨");
        replyDTO.setR_writer("lim");
//        log.info("Reply레지스트:"+ replyDTO);
//        log.info("Reply레지스트:"+ b_dtt);
//        log.info("Reply레지스트:"+ replyDTO.getB_num());
//        log.info("Reply레지스트페이지 넘버:"+ criteria.getPage());
        log.info("Reply레지스트:"+ b_dtt);
        bDate = replyDTO.getB_num(); //리드에 보내줄 게시판 날짜 값
        replyServiceImpl.insertReply(replyDTO);
        //http://localhost:7090/board/read?b_dtt=2021/03/26%2020:10:05&page=1&join=210326201005
        return "redirect:/board/read?b_dtt=" + bDate + "&page=" + criteria.getPage() + "&join=" + replyDTO.getB_no();
    }

    @PostMapping("/remove")
    public String replyRemove(String r_dtt, String b_dtt, String page, String join){
        log.info("Reply리무브:"+ r_dtt);
        replyServiceImpl.deleteReply(r_dtt);
        return "redirect:/board/read?b_dtt=" + b_dtt + "&page=" + page + "&join=" + join;
    }

    @GetMapping("/modifyRepl")
    public void read(String r_dtt){
        modiR_dtt = r_dtt;
        log.info("리플모디파이 겟 호출");
        log.info("겟모디파이");
        log.info("겟모디파이:"+ r_dtt);

    }
    @PostMapping("/modify")
    public String modify(ReplyDTO replyDTO){
        log.info("포스트리플라이 수정");
        log.info("포스트리플라이 수정 기본키:"+ modiR_dtt);
        log.info("포스트리플라이 수정 내용:" + replyDTO.getR_content());
        replyServiceImpl.updateReply(replyDTO.getR_content(), modiR_dtt);
        return null;
    }


}
