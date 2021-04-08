package org.zerock.boardtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class UploadTestControllerA {
    @GetMapping("/uploadEx")
    public void uploadEx(){

    }
}
