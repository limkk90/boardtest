package org.zerock.boardtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.boardtest.dto.ReplyDTO;
import org.zerock.boardtest.mapper.MainMapper;

import java.util.List;

@Log4j2
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired(required = false)
    MainMapper mainMapper;
    @Override
    public void insertReply(ReplyDTO replyDTO) {
        log.info("ReplyImpl:"+ replyDTO);
        String content = replyDTO.getR_content();
        String b_no = replyDTO.getB_no();
        log.info("ReplyImpl:"+ content);
        log.info("ReplyImpl:"+b_no);
        mainMapper.insertReply(replyDTO);
    }

    @Override
    public List<ReplyDTO> getReplyList(String bDate) {
        log.info("IMPL리플라이리스트:"+ bDate);
        log.info(mainMapper.getReplyList(bDate));
        return mainMapper.getReplyList(bDate);
    }

    @Override
    public void deleteReply(String bDate) {
        log.info("IMPL리플라이리무브:"+ bDate);
        mainMapper.deleteReply(bDate);
    }

    @Override
    public void updateReply(String content, String r_dtt) {
        mainMapper.updateReply(content, r_dtt);
    }

}
