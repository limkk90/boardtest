package com.myapp;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(){
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
