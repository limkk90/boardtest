package org.zerock.boardtest.service;

import org.zerock.boardtest.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    void insertReply(ReplyDTO replyDTO);
    List<ReplyDTO> getReplyList(String bDate);
    void deleteReply (String bDate);
}
