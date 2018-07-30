package com.iotek.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/7/30.
 */
@Controller
public class Y_YController {
    @RequestMapping("/managerLongin")
    public String managerLongin(){
        return "../../Login";
    }
    @RequestMapping("/index1")
    public String index1(){
        return "../../index";
    }
}
