package com.iotek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/26.
 */
@Controller
public class Y_YController {
@RequestMapping("/tourist")
    public String tourist(){
    return"tourist";
    }
    @RequestMapping("/exit")
    public String exit(){
        return"../../index";
    }

   /* @RequestMapping("/emplogin")
    public String emplogin(){
        return "emp/"
    }*/
}
