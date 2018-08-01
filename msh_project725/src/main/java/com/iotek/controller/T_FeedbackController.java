package com.iotek.controller;

import com.iotek.model.T_Feedback;
import com.iotek.model.T_Recruit;
import com.iotek.model.T_Resume;
import com.iotek.model.T_Tourist;
import com.iotek.service.T_FeedbackService;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/29.
 */
@Controller
public class T_FeedbackController {
    @Resource
    private T_FeedbackService tfs;
    @Resource
    private T_RecruitService trs;

    @RequestMapping("/recruit3")
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
            return "recruit2";
        }else{
            request.setAttribute("norecruits","暂时没有发布任何职位！");
            return "recruit2";
        }
    }
    @RequestMapping("/saveFeedback2")
    public String saveFeedback2(int re_id, HttpSession session, HttpServletRequest request)throws Exception{
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        int r_id= (int) session.getAttribute("r_id");
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setT_id(tourist.getT_id());
        tFeedback.setF_state(0);
        tFeedback.setF_read(0);
        tFeedback.setR_id(r_id);
        Date day=new Date();//获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  btime=df.format(day);
        tFeedback.setF_btime(btime);
        tFeedback.setF_interviewtime("0");
        tFeedback.setRe_id(re_id);

        //先要判断这份简历在之前是否投递过
        if (tfs.getFeedbackByR_id(tFeedback)!=null){
            request.setAttribute("Feedback1","已经投递过了！");
            int currentPage=1;
            return getRecruit(currentPage,request);
        }else{
            System.out.println(tFeedback);
            boolean falg=tfs.saveFeedback(tFeedback);
            request.setAttribute("Feedback2","投递成功！");
            int currentPage=1;
            return getRecruit(currentPage,request);
        }
    }
    //查看有没有获得面试邀请
    @RequestMapping("/state1")
    public String state1(int currentPage,HttpSession session,HttpServletRequest request)throws Exception{
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setT_id(tourist.getT_id());
        tFeedback.setF_state(1);
        List<T_Feedback> t_feedbacks=tfs.getFeedbackState1(tFeedback);
        if (t_feedbacks.size()!=0){
            int totalRows =t_feedbacks.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE=5;
        /*List<Good> goods=goodService.getqueryCurrentPageGood(state,currentPage,PAGESIZE);*/
            Map<String,Object> data=new HashMap<>();
            data.put("currentPage",(currentPage-1)*PAGESIZE+1);
            data.put("pageSize",(currentPage) * PAGESIZE);
            int state=1;
            int tid=tourist.getT_id();
            data.put("state",state);
            data.put("tid",tid);
            List<T_Feedback> t_feedbacks1=tfs.getFeedbacks(data);
            request.setAttribute("state1",t_feedbacks1);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("trs",trs);
            return "interview";
        }else{
            request.setAttribute("nostate1","暂时还未获取面试机会");
            return "interview";
        }
    }
    //对面试邀请的接受或者拒绝
    @RequestMapping("/updatestate34")
    public String updatestate34(int state,int f_id,HttpServletRequest request,HttpSession session)throws Exception{
        if (state==4){
            T_Feedback tFeedback=new T_Feedback();
            tFeedback.setF_state(4);
            tFeedback.setF_id(f_id);
            boolean falg=tfs.updateFeedBackState(tFeedback);
            request.setAttribute("state3","准备面试，不要迟到！");
            int currentPage=1;
            return state1( currentPage,session,request);
        }else{
            T_Feedback tFeedback=new T_Feedback();
            tFeedback.setF_state(3);
            tFeedback.setF_id(f_id);
            boolean falg=tfs.updateFeedBackState(tFeedback);
            request.setAttribute("state4","感谢您对本公司的支持！");
            int currentPage=1;
            return state1( currentPage,session,request);
        }
    }
}
