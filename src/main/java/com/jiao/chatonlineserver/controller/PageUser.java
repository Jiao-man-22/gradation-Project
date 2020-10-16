package com.jiao.chatonlineserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PageUser {
    @RequestMapping("/user/{page}")
    public String turnPage(@PathVariable String page){
        return page;
    }
    @RequestMapping("/TestPage")
    public String testPage(){
        return "/TestPage";
    }
}
