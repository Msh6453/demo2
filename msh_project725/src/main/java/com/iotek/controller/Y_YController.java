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
    @RequestMapping("/saveFeedback1")
    public String saveFeedback1(int r_id, HttpSession session){
        session.setAttribute("r_id",r_id);
        return"saveFeedback11";
    }
   /* @RequestMapping("/emplogin")
    public String emplogin(){
        return "emp/"
    }*/
}
