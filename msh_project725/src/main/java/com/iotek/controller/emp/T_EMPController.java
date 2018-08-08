package com.iotek.controller.emp;

import com.iotek.model.*;
import com.iotek.service.*;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/8/2.
 */
@Controller
public class T_EMPController {
    @Resource
    private T_EmpService tes;
    @Resource
    private T_DeptService tds;
    @Resource
    private T_PositionService tps;
    @Resource
    private T_AttenceService tas;
    @Resource
    private T_RwdpenService trs;
    @Resource
    private T_SalaryService tss;
    @Resource
    private T_AppealService tass;
    @Resource
    private T_TrainService tts;
    @Resource
    private T_Emp_TrainService tets;
    //员工登录
    @RequestMapping("/emplogin")
    public String emplogin(T_Emp t_emp, HttpServletRequest request, HttpSession session)throws Exception{
        //还需要判断该员工是不是已经离职了离职员工不能登录。

        if (t_emp.getE_num()==""||t_emp.getE_password()==""){
            request.setAttribute("noemp","账号和密码不能为空");
            return "../../emp";
        }
        T_Emp tEmp=tes.getEmpByNumAndPassword(t_emp);
        if (tEmp!=null){
            if (tEmp.getE_state()==3){
                request.setAttribute("state3","对不起，您已经离职！");
                return "../../emp";
            }
            session.setAttribute("success",tEmp);
            session.setAttribute("emp",tEmp);
            return "emp/e_empFrist";
        }else{
            request.setAttribute("noemp1","账号和密码错误！");
            return "../../emp";
        }
    }
    //返回主界面
    @RequestMapping("/empjsp")
    public String empjsp(){
        return "emp/e_empFrist";
    }
    @RequestMapping("/e_info")
    public String infomyself(int eid,HttpServletRequest request){
        T_Emp tEmp1=new T_Emp();
        tEmp1.setE_id(eid);
        T_Emp tEmp=tes.getT_Emp(tEmp1);
        System.out.println(tEmp);
        request.setAttribute("temp",tEmp);
        request.setAttribute("tds",tds);
        request.setAttribute("tps",tps);
        return "emp/e_info";
    }
    @RequestMapping("/updateemp")
    public String updateemp(){
        return "emp/e_updateemp";
    }
    //修改密码和地址和电话
    @RequestMapping("/updateEMP2")
    public String updateEMP2(T_Emp t_emp,HttpServletRequest request)throws Exception{
        boolean falg=tes.updateEmpxxx(t_emp);
        T_Emp tEmp=tes.getT_Emp(t_emp);
        request.setAttribute("temp",tEmp);
        request.setAttribute("tds",tds);
        request.setAttribute("tps",tps);
        return "emp/e_info";

    }
    //查看个人考勤
    @RequestMapping("/e_attence")
    public String attence(int currentPage,HttpServletRequest request,HttpSession session){
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        T_Attence tata=new T_Attence();
        tata.setE_id(e_id);
        List<T_Attence> ta=tas.getAllAttenceByEid(tata);
        if (ta.size()!=0){
            int totalRows = ta.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("e_id",e_id);

            List<T_Attence> tat=tas.getAllAttenceByEidCuu(data);
            request.setAttribute("tat", tat);
            request.setAttribute("totalPages",totalPages);

            return  "emp/m_getAttence";
        }else{
            request.setAttribute("notAttence","暂时没有考勤记录");
            return  "emp/m_getAttence";
        }
    }
    //查看个人当月奖惩
    @RequestMapping("/e_rwdpen")
    public String rwdpen(int currentPage,HttpServletRequest request,HttpSession session){
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        Date day=new Date();//获取当前时间
        //产生奖惩记录的时候会用到。。。。。
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime=df0.format(day);
        T_Rwdpen tr=new T_Rwdpen();
        tr.setRp_moth(mtime);
        tr.setE_id(e_id);
        List<T_Rwdpen> tr1=trs.getT_RwdpenByEidAndMoth(tr);
        if (tr1.size()!=0){
            int totalRows = tr1.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("eid",e_id);
            data.put("moth",mtime);

            List<T_Rwdpen> tr2=trs.getT_RwdpenByEidAndMothCurr(data);
            request.setAttribute("tr2", tr2);
            request.setAttribute("totalPages",totalPages);
            return "emp/e_getRwdpen";
        }else{
         request.setAttribute("noredpen1","这个月暂时没有奖惩记录");
         return "emp/e_getRwdpen";
        }
    }
    @RequestMapping("/getRwdpenByMoth")
    public String getRwdpenByMoth(int currentPage,String moth,HttpSession session,HttpServletRequest request)throws Exception{
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        System.out.println(moth);

        T_Rwdpen tr=new T_Rwdpen();
        tr.setRp_moth(moth);
        tr.setE_id(e_id);
        List<T_Rwdpen> tr1=trs.getT_RwdpenByEidAndMoth(tr);
        if (tr1.size()!=0){
            int totalRows = tr1.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("eid",e_id);
            data.put("moth",moth);

            List<T_Rwdpen> tr2=trs.getT_RwdpenByEidAndMothCurr(data);
            request.setAttribute("tr2", tr2);
            request.setAttribute("totalPages",totalPages);
            return "emp/e_getRwdpen";
        }else{
            request.setAttribute("noredpen","查询的这个月暂时没有奖惩记录");
            return "emp/e_getRwdpen";
        }
    }
    @RequestMapping("/e_salary")
    public String salary(HttpServletRequest request,HttpSession session)throws Exception{
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        Date day=new Date();//获取当前时间
        //产生奖惩记录的时候会用到。。。。。

        //首先判断这个月是不是已经过了10号，没过10号就不能查看上一个月的薪资
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime=df0.format(day);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//获取今天的日期
        String time1=df1.format(day);//获取今天的日期
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String atime=mtime+"-10 00:00:00";//
        String btime=mtime+"-10 24:00:00";//
        long day101=0;
        long day102=0;
        try {
            day101=df2.parse(atime).getTime();//
            day102=df2.parse(btime).getTime();//
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        long today=day.getTime();
        System.out.println(today);
        System.out.println("xxxxxx");
        System.out.println(day102);

        if (today>day102){//判断当前时间是否在当月10号之后

        }else{
            request.setAttribute("nojiesuan","上月工资还未结算");
            return "emp/e_salary";
        }

        //还需要考虑上一个月有没有考勤
        //生成上一个月的月份
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String uptime=df0.format(m);//上一个月的月份，如果2018-8，这个2018-7；

        //根据员工id和当前月份，查找这个月的薪资；
        T_Salary ts=new T_Salary();
        ts.setSa_month(uptime);
        ts.setE_id(e_id);
        System.out.println(ts);
        T_Salary ts1=tss.getT_SalaryByEidAndMoth(ts);
        System.out.println(ts1);

        if (ts1!=null){
            request.setAttribute("ts2", ts1);
            return "emp/e_getSalary";
        }else{
            request.setAttribute("noSalary","上月没有薪资！");
            return "emp/e_getSalary";
        }
    }
    @RequestMapping("/getSalaryByMonth")
    public  String getSalaryByMonth(String month,HttpSession session,HttpServletRequest request)throws Exception{
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        T_Salary ts=new T_Salary();
        ts.setSa_month(month);
        ts.setE_id(e_id);
        System.out.println(ts);
        T_Salary ts1=tss.getT_SalaryByEidAndMoth(ts);
        if (ts1!=null){
            request.setAttribute("ts2", ts1);
            return "emp/e_getSalary1";
        }else{
            request.setAttribute("noSalary","这月没有薪资！");
            return "emp/e_Salary1";
        }
    }
    //上一个月的工资复议
    @RequestMapping("/saveAppeal")
    public String saveAppeal(T_Appeal t_appeal, HttpServletRequest request, HttpSession session)throws Exception {
        T_Emp e = (T_Emp) session.getAttribute("emp");
        int e_id = e.getE_id();//获取到了员工id
        Date day = new Date();//获取当前时间

        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime = df0.format(day);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String time1 = df2.format(day);//获取今天的日期
        //生成上一个月的月份
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String uptime = df0.format(m);//上一个月的月份，如果2018-8，这个2018-7；

        T_Appeal tapp=new T_Appeal();
        tapp.setApp_month(uptime);
        tapp.setApp_reason(t_appeal.getApp_reason());
        tapp.setApp_time(time1);
        tapp.setApp_state(0);//state=0说明还未回复，state=1已经回复
        tapp.setE_id(e_id);
        boolean falg=tass.saveAppeal(tapp);
        request.setAttribute("haveapp","复议成功，等待处理！");
        return salary( request, session);
    }
    //查看个人培训
    @RequestMapping("/e_train")
    public String e_train(int  currentPage,HttpSession session ,HttpServletRequest request){
        T_Emp e = (T_Emp) session.getAttribute("emp");
        int e_id = e.getE_id();//获取到了员工id
        System.out.println(e_id);
        T_Emp_Train te=new T_Emp_Train();
        te.setE_id(e_id);
        List<T_Emp_Train> tet=tets.getEmpAndTrainByEid(te);
        if (tet.size()!=0){
            int totalRows = tet.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            data.put("eid",e_id);

            List<T_Emp_Train> tet2=tets.getEmpAndTrainByEidCurr(data);
            request.setAttribute("tet2", tet2);
            request.setAttribute("tts",tts);
            request.setAttribute("totalPages",totalPages);

            return  "emp/e_getTrain";
        }else{
            request.setAttribute("notTrain","暂时没有培训记录");
            return  "emp/e_empFrist";
        }
    }
}
