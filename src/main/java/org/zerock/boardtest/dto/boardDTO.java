package org.zerock.boardtest.dto;


import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class boardDTO {
    private char cat_cd;
    private String b_title;
    private String b_content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime b_dtt;
    private String u_id;
    private String joinBnum;

}
