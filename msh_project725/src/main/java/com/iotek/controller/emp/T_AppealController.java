package com.iotek.controller.emp;

import com.iotek.model.T_Appeal;
import com.iotek.model.T_Emp;
import com.iotek.service.T_AppealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/8/8.
 */
@Controller
public class T_AppealController {
    @Resource
    private T_AppealService tas;
    @RequestMapping("/saveAppeal2")
    public String saveAppeal2(String month,HttpSession session){
        session.setAttribute("mon",month);
        return "emp/e_saveAppeal2";
    }
    //员工查看已经回复的薪资复议
    @RequestMapping("/e_appeal")
    public String appeal(HttpSession session,HttpServletRequest request,int currentPage){
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        T_Appeal ta=new T_Appeal();
        int state=1;
        ta.setApp_state(state);
        ta.setE_id(e_id);
        List<T_Appeal> taa=tas.getAppealByEidAndState1(ta);
        if (taa.size()!=0){
            int totalRows = taa.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("e_id",e_id);
            data.put("app_state",state);

            List<T_Appeal> taa1=tas.getAppealByEidAndState1Curr(data);
            request.setAttribute("taa1", taa1);
            request.setAttribute("totalPages",totalPages);

            return  "emp/e_getAppeal";
        }else{
            request.setAttribute("notAppeal","没有已回复的复议！");
            return  "emp/e_empFrist";
        }
    }
    //管理员查看需要回复的复议

    @RequestMapping("/m_getAppeal")
    public String m_getAppeal(int currentPage,HttpServletRequest request)throws Exception{
        T_Appeal tap=new T_Appeal();
        int state=0;
        tap.setApp_state(state);
        List<T_Appeal> taa=tas.getAppealByState0(tap);
        if (taa.size()!=0){
            int totalRows = taa.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("app_state",state);

            List<T_Appeal> taa1=tas.getAppealByState0Curr(data);
            request.setAttribute("taa1", taa1);
            request.setAttribute("totalPages",totalPages);

            return  "manager/m_getAppeal";
        }else{
            request.setAttribute("notAppeal","没有待回复的复议！");
            return  "manager/m_salary";
        }
    }
    @RequestMapping("/updateAppeal")
    public String updateAppeal(T_Appeal t_appeal,HttpServletRequest request)throws Exception{
        T_Appeal tap=tas.getAppeal(t_appeal);
        request.setAttribute("tap",tap);
        return "manager/m_updateAppeal2";
    }
    //管理员的回复复议就是修改并将state改为1
    @RequestMapping("/updateAppeal2")
    public String updateAppeal2(T_Appeal t_appeal,HttpServletRequest request){
        boolean falg=tas.updateAppeal(t_appeal);
        request.setAttribute("haveAppeal","复议已经回复！");
        return  "manager/m_salary";
    }
}
