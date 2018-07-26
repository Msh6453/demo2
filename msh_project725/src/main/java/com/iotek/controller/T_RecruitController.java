package com.iotek.controller;

import com.iotek.model.T_Recruit;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/25.
 */
@Controller
public class T_RecruitController {
    @Resource
    private T_RecruitService trs;
    @RequestMapping("/recruit")
    public String getRecruit(int currentPage,HttpServletRequest request){
        if (currentPage==0){
            currentPage=1;
        }
        T_Recruit tRecruit=new T_Recruit();
        int state=2;
        tRecruit.setR_state(state);
        List<T_Recruit> recruits=trs.getRecruits(tRecruit);
        int totalRows =recruits.size();
        int totalPages = DoPage.getTotalPages(totalRows);//总页数
        final int PAGESIZE=5;
        /*List<Good> goods=goodService.getqueryCurrentPageGood(state,currentPage,PAGESIZE);*/
        Map<String,Object> data=new HashMap<>();
        data.put("currentPage",(currentPage-1)*PAGESIZE+1);
        data.put("pageSize",(currentPage) * PAGESIZE);
        data.put("state",state);
        List<T_Recruit> t_recruits=trs.get(data);
        if (recruits!=null){
            request.setAttribute("recruitlist",t_recruits);
            request.setAttribute("totalPages",totalPages);
            return "recruit";
        }else{
            request.setAttribute("norecruits","暂时没有发布任何职位！");
            return "recruit";
        }
    }
}
