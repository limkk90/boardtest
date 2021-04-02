package org.zerock.boardtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDTO {
    private LocalDateTime r_dtt;
    private String r_content;
    private String r_writer;
    private String b_no;
    private String b_num;
}
