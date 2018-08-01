package com.iotek.controller.manager;

import com.iotek.model.T_Feedback;
import com.iotek.service.T_FeedbackService;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/7/30.
 */
@Controller
public class T_MFeedBackController {
    @Resource
    private T_FeedbackService tfs;
    @Resource
    private T_RecruitService trs;
    @RequestMapping("/m_feedback")
    public  String m_feedback(){
        return "manager/m_feedback";
    }
    @RequestMapping("/getT_FeedBack")
    public String getT_FeedBack(int currentPage,HttpServletRequest request)throws Exception{
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setF_state(0);
        List<T_Feedback> tFeedbacks=tfs. getFeedBacksAll();
        if (tFeedbacks.size()!=0) {
            int totalRows = tFeedbacks.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);

            List<T_Feedback> t_feedbacks1 = tfs.getFeedbacksByState0(data);
            request.setAttribute("state0",t_feedbacks1);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("trs",trs);
            return "manager/m_getfeedback";
        }else{
            request.setAttribute("nostate0","还没有人投递过简历！");
            return "manager/m_feedback";
        }
    }
    @RequestMapping("/back1")
    public String back(int currentPage,HttpServletRequest request)throws Exception{

        return getT_FeedBack(currentPage,request);
    }
    //发出邀请面试，不符合条件，该表条件
    @RequestMapping("/updatestate15")
    public String updatestate15(int state,int f_id ,HttpServletRequest request)throws Exception{
        T_Feedback tFeedback1=new T_Feedback();
        tFeedback1.setF_id(f_id);
        T_Feedback tFeedback2=tfs.getTF(tFeedback1);
        if (tFeedback2.getF_state()==1){
            request.setAttribute("state1","您已经发出过了面试邀请");
            int currentPage=1;
            return getT_FeedBack(currentPage,request);//返回页面
        }else if (tFeedback2.getF_state()==5){
            request.setAttribute("state5","您已经查阅过了，并且拒绝了！");
            int currentPage=1;
            return getT_FeedBack(currentPage,request);//返回页面
        }else{
            if(state==1){//发出面试邀请，生成面试时间
                T_Feedback tFeedback=new T_Feedback();

                Date day=new Date();//获取当前时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long a=day.getTime();//变成毫秒
                System.out.println(a);
                long b=1*24*3600*1000;
                long c=a+b;
                Calendar ca = Calendar.getInstance();
                ca.setTimeInMillis(c);
                Date date = ca.getTime();
                String ntime=df.format(date);

                tFeedback.setF_interviewtime(ntime);
                tFeedback.setF_state(state);
                tFeedback.setF_id(f_id);
                boolean falg=tfs.updateFeedBackStateAndTime(tFeedback);

                int currentPage=1;
                return getT_FeedBack(currentPage,request);//返回页面
            }else{
                T_Feedback tFeedback=new T_Feedback();
                tFeedback.setF_state(state);
                tFeedback.setF_id(f_id);
                boolean falg=tfs.updateFeedBackState(tFeedback);
                int currentPage=1;
                return getT_FeedBack(currentPage,request);//返回页面
            }
        }
    }
    //查看已经接受面试员工开始录用
    @RequestMapping("/getT_FeedBackbystate4")
    public String getT_FeedBackbystate4(int currentPage,HttpServletRequest request){
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setF_state(4);
        List<T_Feedback> tFeedbacks=tfs.getFeedBacksState4(tFeedback);
        if (tFeedbacks.size()!=0) {
            int totalRows = tFeedbacks.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            int state=4;
            data.put("state",state);

            List<T_Feedback> t_feedbacks1 = tfs.getFeedbacksByState4(data);
            request.setAttribute("state4",t_feedbacks1);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("trs",trs);
            return "manager/m_feedbackstate4";
        }else{
            request.setAttribute("nostate4","还没有人接受面试！");
            return "manager/m_feedbackstate4";
        }
    }
    @RequestMapping("/updatestate67")
    public String updatestate67(int state,int f_id,HttpServletRequest request){
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setF_state(state);
        tFeedback.setF_id(f_id);
        //先要判断这个人之前是否被录用
        //先是通过f_id查找简历中t_id，判断t_id在之前是否存在过
        T_Feedback tFeedback2=tfs.getTF(tFeedback);
        int t_id=tFeedback2.getT_id();
        int state1=6;
        T_Feedback tFeedback4=new T_Feedback();
        tFeedback4.setF_state(state1);
        tFeedback4.setT_id(t_id);
        List<T_Feedback> tFeedback3= tfs.getFeedbackState1(tFeedback4);
        System.out.println(tFeedback3.size());
        int currentPage=1;
        if (tFeedback3.size()!=0){
            request.setAttribute("state61","该员工的其他简历已经被录用过了");
            return getT_FeedBackbystate4( currentPage,request);
        }



        if (state==6){//点击录用
            boolean falg=tfs.updateFeedBackState(tFeedback);
            request.setAttribute("state6","录用成功！");

           return getT_FeedBackbystate4( currentPage,request);
        }else{//点击不录用
            boolean falg=tfs.updateFeedBackState(tFeedback);
            request.setAttribute("state7","已拒绝录用");

           return  getT_FeedBackbystate4( currentPage,request);
        }
    }
}
