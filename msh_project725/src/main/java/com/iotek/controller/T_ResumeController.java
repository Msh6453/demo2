package com.iotek.controller;

import com.iotek.model.T_Feedback;
import com.iotek.model.T_Resume;
import com.iotek.model.T_Tourist;
import com.iotek.service.T_FeedbackService;
import com.iotek.service.T_ResumeService;
import com.iotek.service.T_TouristService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/26.
 */
@Controller
public class T_ResumeController {
    @Resource
    private T_ResumeService ts;
    @Resource
    private T_FeedbackService tfs;
    @RequestMapping("/saveResume")
    public String save(T_Resume t_resume,HttpSession session, HttpServletRequest request)throws Exception{
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        t_resume.setT_id(tourist.getT_id());
        boolean falg=ts.saveResume(t_resume);
        request.setAttribute("resume","添加成功");
        return "tourist";
    }
    @RequestMapping("/getresume")
    public String getresume(int currentPage,HttpServletRequest request,HttpSession session){
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        T_Resume t_resume = new T_Resume();
        t_resume.setT_id(tourist.getT_id());
        List<T_Resume> t_resumes=ts.getresume(t_resume);
        int totalRows =t_resumes.size();
        int totalPages = DoPage.getTotalPages(totalRows);//总页数
        final int PAGESIZE=5;
        Map<String,Object> data=new HashMap<>();
        data.put("currentPage",(currentPage-1)*PAGESIZE+1);
        data.put("pageSize",(currentPage) * PAGESIZE);
        data.put("tid",tourist.getT_id());
        List<T_Resume> tResumes=ts.get(data);
        if (tResumes.size()!=0){
            request.setAttribute("totalPages",totalPages);
            session.setAttribute("totalPages",totalPages);
            request.setAttribute("tResumes",tResumes);
            session.setAttribute("tResumes",tResumes);
            return "tourist";
        }else{
            request.setAttribute("noResumes","您还没有添加简历");
            return "tourist";
        }
    }




    @RequestMapping("/getresume1")
    public String getresume1(int currentPage,HttpServletRequest request,HttpSession session){
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        T_Resume t_resume = new T_Resume();
        t_resume.setT_id(tourist.getT_id());
        List<T_Resume> t_resumes=ts.getresume(t_resume);
        int totalRows =t_resumes.size();
        int totalPages = DoPage.getTotalPages(totalRows);//总页数
        final int PAGESIZE=5;
        Map<String,Object> data=new HashMap<>();
        data.put("currentPage",(currentPage-1)*PAGESIZE+1);
        data.put("pageSize",(currentPage) * PAGESIZE);
        data.put("tid",tourist.getT_id());
        List<T_Resume> tResumes=ts.get(data);
        if (tResumes.size()!=0){

            session.setAttribute("totalPages",totalPages);

            session.setAttribute("tResumes",tResumes);
            return "saveFeedback11";
        }else{
            request.setAttribute("noResumes","您还没有添加简历");
            return "saveFeedback11";
        }
    }
    @RequestMapping("/updateresume1")
    public String updateresume1(int re_id,HttpServletRequest request){
        T_Resume tResume=new T_Resume();
        tResume.setRe_id(re_id);
        T_Resume tResume1=ts.getRe(tResume);
        request.setAttribute("getRe",tResume1);
        return "updateresume";
    }
    @RequestMapping("/updateresume2")
    public String updateresume2(T_Resume t_resume, HttpServletRequest request){
        boolean falg=ts.updateResume(t_resume);
        return "tourist";
    }
    @RequestMapping("/deleteresume")
    public String deleteresume(T_Resume t_resume){
        boolean falg=ts.deleteResume(t_resume);
        return "tourist";
    }
    @RequestMapping("/getmresume")
    public String getmresume(int a,int re_id,int f_read,int f_id,HttpServletRequest request)throws Exception{

        T_Resume tResume=new T_Resume();
        tResume.setRe_id(re_id);
        T_Resume tResume1=ts.getRe(tResume);
        //点击查看详情，判断f_read的状态，查看玩之后应该是已读状态f_read=1
        T_Feedback tFeedback=new T_Feedback();
        tFeedback.setF_read(1);
        tFeedback.setF_id(f_id);
        System.out.println(tFeedback);
        if (f_read==0){
            boolean falg=tfs.updateFeedBackRead(tFeedback);
        }
        request.setAttribute("tResume1",tResume1);
        if (a==1){
            return "manager/m_resume";
        }else if (a==2){
            return "manager/m_resume2";
        }else{

            return "manager/m_resume3";
        }

    }
}
