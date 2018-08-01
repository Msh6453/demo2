package com.iotek.controller;

import com.iotek.model.T_Dept;
import com.iotek.model.T_Recruit;
import com.iotek.service.T_DeptService;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private T_DeptService tds;
    @RequestMapping("/recruit")
    public String getRecruit(int currentPage,HttpServletRequest request){

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
    @RequestMapping("/recruitCenter")
        public String recruitCenter(){
            return "manager/m_recruit";
        }
        //管理员查看全部招聘信息
    @RequestMapping("/getm_recruit")
    public String getm_recruit(int currentPage,HttpServletRequest request)throws Exception{
        List<T_Recruit> recruits=trs.getm_Recruits();
        int totalRows =recruits.size();
        int totalPages = DoPage.getTotalPages(totalRows);//总页数
        final int PAGESIZE=5;
        Map<String,Object> data=new HashMap<>();
        data.put("currentPage",(currentPage-1)*PAGESIZE+1);
        data.put("pageSize",(currentPage) * PAGESIZE);
        List<T_Recruit> t_recruits=trs.getM(data);
        if (recruits!=null){
            request.setAttribute("recruitlist",t_recruits);
            request.setAttribute("totalPages",totalPages);
            return "manager/m_getrecruit";
        }else{
            request.setAttribute("norecruits","暂时招聘任何职位！");
            return "manager/m_recruit";
        }
    }
    @RequestMapping("/savem_recruit1")
    public String savem_recruit(HttpServletRequest request)throws Exception{
        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tDepts",tDepts);
        return "manager/m_saverecruit";
    }
    //增加招聘信息
    @RequestMapping("/save2_recruit")
    public String save2_recruit( T_Recruit t_recruit,HttpServletRequest request)throws Exception{
        System.out.println(t_recruit);
       t_recruit.setR_state(1);
       t_recruit.setR_begintime("0");
        boolean falg=trs.saveRecruits(t_recruit);
        request.setAttribute("save2","添加招聘信息成功");
        return "manager/m_recruit";
    }
    @RequestMapping("/mrecruit")
    public String mrecruit(){
        return "manager/m_recruit";
    }
    @RequestMapping("/updaterecruit12")
    public String updaterecruit12(int r_id,int r_state,int r,HttpServletRequest request)throws Exception{
        int currentPage=1;
        if(r==2){//想要发布
            if (r_state==2){//判断是否已经发布
                request.setAttribute("state2","该招聘信息之前已经发布了");
                return getm_recruit( currentPage, request);
            }else{
                T_Recruit tRecruit1=new T_Recruit();
                tRecruit1.setR_id(r_id);
                //改变发布招聘信息的时间
                Date day=new Date();//获取当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String  btime=df.format(day);
                tRecruit1.setR_begintime(btime);
                tRecruit1.setR_state(r);
                boolean falg=trs.updateRecruitsStateAndBtime(tRecruit1);
                return getm_recruit( currentPage,request);
            }
        } else{
            if (r_state==1){
                request.setAttribute("state1","该招聘信息已经撤销过了");
                return getm_recruit( currentPage,request);
            }else{
                T_Recruit tRecruit1=new T_Recruit();
                tRecruit1.setR_id(r_id);
                tRecruit1.setR_state(r);
                boolean falg=trs.updateRecruitsState(tRecruit1);
                return getm_recruit( currentPage,request);
            }
        }
    }
    @RequestMapping("/deleterecruit")
    public String deleterecruit(int r_id, HttpServletRequest request)throws Exception{
        int currentPage=1;
        T_Recruit tRecruit1=new T_Recruit();
        tRecruit1.setR_id(r_id);
        boolean falg=trs.deleteRecruits(tRecruit1);
        return getm_recruit( currentPage,request);
    }
    @RequestMapping("/updaterecruit1")
    public String updaterecruit1(int r_id , HttpServletRequest request)throws Exception{
        T_Recruit tRecruit1=new T_Recruit();
        tRecruit1.setR_id(r_id);
        T_Recruit tRecruit=trs.getByR_id(tRecruit1);
        request.setAttribute("updaterecruit1",tRecruit);
        return "manager/m_updaterecruit2";
    }
    @RequestMapping("/updaterecruit2")
    public String updaterecruit2(T_Recruit t_recruit,HttpServletRequest request)throws Exception{
        boolean falg=trs.updateRecruits(t_recruit);
        int currentPage=1;
        return getm_recruit(currentPage, request);
    }
}
