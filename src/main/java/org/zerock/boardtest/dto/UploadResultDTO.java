package org.zerock.boardtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable {

    private String f_no; //파일 넘버(시퀀스)
    private String f_ori_nm; //원래 이름
    private String f_sv_nm; //서버이름
    private long f_capacity; //용량
    private String f_ext; //확장자
    private String b_no; //게시글 번호

    public UploadResultDTO(String f_ori_nm, String f_no, String f_sv_nm) {
        this.f_ori_nm = f_ori_nm;
        this.f_no = f_no;
        this.f_sv_nm = f_sv_nm;
    }

    public String getImageURL(){
        try {
            return URLEncoder.encode(f_sv_nm+"/"+f_no+"_"+f_ori_nm,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
