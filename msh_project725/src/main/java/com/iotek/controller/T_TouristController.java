package com.iotek.controller;

import com.iotek.model.T_Recruit;
import com.iotek.model.T_Resume;
import com.iotek.model.T_Tourist;
import com.iotek.service.T_RecruitService;
import com.iotek.service.T_ResumeService;
import com.iotek.service.T_TouristService;
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
 * Created by Administrator on 2018/7/25.
 */
@Controller
public class T_TouristController {
    @Resource
    private T_TouristService ts;
    @Resource
    private T_RecruitService trs;
    @Resource
    private T_ResumeService trss;
    @RequestMapping("/recruit2")
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
    @RequestMapping("/login")
    public String login(T_Tourist t_tourist, HttpServletRequest request, HttpSession session){
        T_Tourist tourist=ts.getLogin(t_tourist);
        if(t_tourist.getT_name()==""||t_tourist.getT_password()==""){
            request.setAttribute("tt","用户名密码不能为空");

            return "../../index";
        }
        if (tourist!=null){
            request.setAttribute("ts",tourist);
            session.setAttribute("tour",tourist);
            int currentPage=1;
            return getRecruit(currentPage,request);
        }else{
            request.setAttribute("ts","用户名密码错误");
            return "../../index";
        }
    }

    @RequestMapping("/saveFeedback1")
    public String saveFeedback1(int r_id,int currentPage, HttpSession session,HttpServletRequest request){
        T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
        T_Resume t_resume = new T_Resume();
        t_resume.setT_id(tourist.getT_id());
        List<T_Resume> t_resumes=trss.getresume(t_resume);
        int totalRows =t_resumes.size();
        int totalPages = DoPage.getTotalPages(totalRows);//总页数
        final int PAGESIZE=5;
        Map<String,Object> data=new HashMap<>();
        data.put("currentPage",(currentPage-1)*PAGESIZE+1);
        data.put("pageSize",(currentPage) * PAGESIZE);
        data.put("tid",tourist.getT_id());
        List<T_Resume> tResumes=trss.get(data);
        if (tResumes.size()!=0){
            request.setAttribute("totalPages",totalPages);

            request.setAttribute("tResumes",tResumes);

            session.setAttribute("r_id",r_id);
            return"saveFeedback11";
        }else{
            request.setAttribute("noResumes","您还没有添加简历");
            return getRecruit(currentPage,request);
        }
    }

    @RequestMapping("/res")
    public String register(T_Tourist t_tourist,HttpServletRequest request){
        T_Tourist tourist=ts.getTouristById(t_tourist);
        if (tourist!=null){
            request.setAttribute("re","用户名已经被注册！");
            return "../../register";
        }else{
            boolean falg=ts.register(t_tourist);
            request.setAttribute("re1","恭喜，注册成功！");
            return "../../register";
        }
    }
}
