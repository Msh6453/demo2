package com.iotek.controller.manager;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/7/31.
 */
@Controller
public class T_EmpController {
    @Resource
    private T_EmpService tes;
    @Resource
    private T_FeedbackService tfs;
    @Resource
    private T_RecruitService trs;
    @Resource
    private T_DeptService tds;
    @Resource
    private T_PositionService tps;
    @Resource
    private T_ResumeService ts;
    //转跳添加员工界面
    @RequestMapping("/saveemp1")
    public String saveemp1(int currentPage, HttpServletRequest request) {
        int state = 6;
        T_Feedback tFeedback = new T_Feedback();
        tFeedback.setF_state(state);
        List<T_Feedback> tFeedbacks = tfs.getFeedBacksState4(tFeedback);
        if (tFeedbacks.size() != 0) {
            int totalRows = tFeedbacks.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("state", state);

            List<T_Feedback> t_feedbacks1 = tfs.getFeedbacksByState4(data);
            request.setAttribute("state6", t_feedbacks1);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("trs", trs);
            return "manager/m_saveemp1";
        } else {
            request.setAttribute("nostate6","还没有被录用的员工");
            return "manager/manager";
        }
    }

    //跳转员工新增页面
    @RequestMapping("/saveemp2")
    public  String saveemp2(int f_id , HttpServletRequest request, HttpSession session){
        session.setAttribute("f_id",f_id);
        //先找出简历id，通过简历id找出员工所有基本信息，让添加页面显示员工基本信息
        T_Feedback tFeedback1=new T_Feedback();
        tFeedback1.setF_id(f_id);
        T_Feedback tFeedback2=tfs.getTF(tFeedback1);

        T_Resume tResume=new T_Resume();
        tResume.setRe_id(tFeedback2.getRe_id());
        T_Resume tResume1=ts.getRe(tResume);

        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tDepts",tDepts);
        request.setAttribute("tRsume1",tResume1);

        return "manager/m_saveEmp2";
    }

    @RequestMapping("/saveemp3")
    public String saveemp3(T_Emp t_emp,HttpServletRequest request,HttpSession session){
        //需要注意的的地方是当员工开始新增的时候，需要将t_feedback的state状态改变为8
        //state=8表示该员工已经录取了，不改变的话它的状态一直是state=6；那么它就会一直存在
        //于添加员工（页面）的里面，就会产生一直可以添加，这是错误的
        int f_id= (int) session.getAttribute("f_id");
        int state=8;
        T_Feedback tFeedback1=new T_Feedback();
        tFeedback1.setF_id(f_id);
        tFeedback1.setF_state(state);
        boolean falg1=tfs.updateFeedBackState(tFeedback1);


        Date day=new Date();//获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  btime=df.format(day);
        System.out.println(btime);

        t_emp.setE_btime(btime);

        System.out.println(t_emp);
        boolean falg=tes.saveTemp(t_emp);
        request.setAttribute("temp","成功添加员工");
        int currentPage=1;
        return saveemp1( currentPage, request);
    }
    //查看所有员工
    @RequestMapping("/getT_Emp")
    public String getT_Emp(int currentPage,HttpServletRequest request)throws Exception{
        List<T_Emp> tEmps=tes.getT_Emps();
        if (tEmps.size()!=0) {
            int totalRows = tEmps.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);


            List<T_Emp> t_emps = tes.getT_EmpsAll(data);
            request.setAttribute("temp", t_emps);
            request.setAttribute("tps",tps);
            request.setAttribute("tds",tds);
            request.setAttribute("totalPages",totalPages);
            return "manager/m_getemp";
        }else{
            request.setAttribute("noemp","暂时没有任何员工");
            return "manager/m_emp";
        }
    }
    //删除员工就是 将其状态改为离职状态
    @RequestMapping("/deleteemp")
    public String deleteemp(int  e_state,int e_id, HttpServletRequest request)throws Exception{
        int currentPage=1;
        if (e_state==3){
            request.setAttribute("state3","该员工已经离职了");
            return  getT_Emp( currentPage, request);
        }
        T_Emp tEmp=new T_Emp();
        tEmp.setE_state(3);
        tEmp.setE_id(e_id);
        boolean falg=tes.updateT_EmpState(tEmp);
        return  getT_Emp( currentPage, request);
    }
    //基本信息不能修改！！！！，只能是换岗
    @RequestMapping("/updateemp1")
    public String updateemp1(int e_id,HttpServletRequest request){
        T_Emp t=new T_Emp();
        t.setE_id(e_id);
        T_Emp tEmp=tes.getT_Emp(t);

        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tDepts",tDepts);
        request.setAttribute("tEmp",tEmp);
        request.setAttribute("tps",tps);
        request.setAttribute("tds",tds);

        return "manager/m_updateEmp";
    }
    //将员工中的d_id，p_id 修改
    @RequestMapping("/updateemp2")
    public String updateemp2(T_Emp t_emp,HttpServletRequest request)throws Exception{
        boolean falg=tes.updateT_Emp(t_emp);
        int currentPage=1;
        return  getT_Emp( currentPage, request);
    }
}
