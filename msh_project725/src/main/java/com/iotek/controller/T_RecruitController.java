package com.iotek.controller;

import com.iotek.model.T_Recruit;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */
@Controller
public class T_RecruitController {
    /*@Resource
    private T_RecruitService trs;
    @RequestMapping("/recruit")
    public String getRecruit(HttpServletRequest request){
        T_Recruit tRecruit=new T_Recruit();
        tRecruit.setR_state(2);
        List<T_Recruit> recruits=trs.getRecruits(tRecruit);
        if (recruits!=null){
            request.setAttribute("recruitlist",recruits);
            return "recruit";
        }else{
            request.setAttribute("norecruits","暂时没有发布任何职位！");
            return "recruit";
        }
    }*/
}
