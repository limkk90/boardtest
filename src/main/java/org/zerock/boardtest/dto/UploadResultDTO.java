package org.zerock.boardtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable {
    private String uuid;
    private String fileName;
    private String folderPath;
    private long fileSize;

    public UploadResultDTO(String fileName, String uuid, String folderPath) {
        this.fileName = fileName;
        this.uuid = uuid;
        this.folderPath = folderPath;
    }

    public String getImageURL(){
        try {
            return URLEncoder.encode(folderPath+"/"+uuid+"_"+fileName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
