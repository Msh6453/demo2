package com.iotek.controller.manager;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */
@Controller
public class T_SalaryController {
    @Resource
    private T_SalaryService tss;
    @Resource
    private T_EmpService tes;
    @Resource
    private T_PositionService tps;
    @Resource
    private T_RwdpenService trs;
    @Resource
    private T_AttenceService tas;
    @RequestMapping("saveSalary")
    public  String saveSalary(HttpServletRequest request)throws Exception{
        // int e_id;//员工id
         //String sa_month;//日期,结算上月工资
         //double sa_salary;//基本工资
        // int sa_state;//状态
         //double sa_rpcost;//奖惩总金额
        // double sa_sscost;//社保费用
        // double sa_bonus;//绩效奖金
        //double sa_allsalary;总工资
        //1、先是查找所有的在职的员工
        T_Emp st=new T_Emp();
        st.setE_state(3);
        List<T_Emp> tEmps=tes.getT_EmpByNoState3(st);
        if (tEmps.size()==0){
            request.setAttribute("noemp","没有在职的员工");
            return "manager/m_salary";
        }


        //2、确定结算工资的日期，每个月的10号。
        Date day=new Date();//获取当前时间
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime=df0.format(day);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//获取今天的日期
        String time1=df1.format(day);//获取今天的日期
        //每个月的10号
        String day10=mtime+"-10";//每个月10号；
        //2.1判断当前时间是不是这个月的10号
        if (day10.equals(time1)){
        }else{
            request.setAttribute("notday10","今天不是结算工资的时间！");
            return "manager/m_salary";
        }
        //2.2先判断这个月10号有没有结算工资。
        T_Salary ts=new T_Salary();
        ts.setSa_month(day10);
        T_Salary ts1=tss.getT_SalaryByDay10(ts);
        if (ts1!=null){//说明这个月10有结算过工资了，不能再结算了
            request.setAttribute("haveday10","这个月工资已经结算过了！");
            return "manager/m_salary";
        }else{
            // int e_id;//员工id
            //String sa_month;//日期,结算上月工资
            //double sa_salary;//基本工资
            // int sa_state;//状态
            //double sa_rpcost;//奖惩总金额
            // double sa_sscost;//社保费用
            // double sa_bonus;//绩效奖金
            for (int i = 0; i <tEmps.size() ; i++) {
                int e_id=tEmps.get(i).getE_id();
                //生成上一个月的月份
                Calendar c = Calendar.getInstance();
                c.setTime(day);
                c.add(Calendar.MONTH, -1);
                Date m = c.getTime();
               String uptime=df0.format(m);//上一个月的月份，如果2018-8，这个2018-7；
                //基本工资
                int p_id=tEmps.get(i).getP_id();
                T_Position tp=new T_Position();
                tp.setP_id(p_id);
                double pay=tps.get_PostionByid(tp).getP_pay();//返回这个员工的基本薪资
                //查看这个人能不能拿到基本工资，查看考勤数是不是满了22天
                T_Attence attence=new T_Attence();
                attence.setA_statex(1);
                attence.setE_id(e_id);
                attence.setA_moth(uptime);
                List<T_Attence> list=tas.getT_AttenceByStatex(attence);
                int count=list.size();



                int state=0;//状态为0；
                //奖惩的金额，需要通过月份，e_id,查表。结算这个月的奖惩，获取总金额
                //先查这个月的奖励的金额，state=1
                T_Rwdpen trp=new T_Rwdpen();
                trp.setE_id(e_id);
                trp.setRp_moth(uptime);
                trp.setRp_state(1);
                List<T_Rwdpen> trp1=trs.getT_RwdpenState1(trp);
                double x=0;
                for (int j = 0; j <trp1.size() ; j++) {
                    double h=trp1.get(i).getRp_money();
                    x+=h;
                }
                //奖励金额
                double state1=x;

                //先查这个月的惩罚的金额，state=0
                T_Rwdpen trp2=new T_Rwdpen();
                trp2.setE_id(e_id);
                trp2.setRp_moth(uptime);
                trp2.setRp_state(0);
                List<T_Rwdpen> trp3=trs.getT_RwdpenState1(trp2);
                double x1=0;
                for (int j = 0; j <trp3.size() ; j++) {
                    double h1=trp3.get(i).getRp_money();
                    x1+=h1;
                }
                //惩罚金额
                double state0=x1;
                //虽然在奖惩里面有过旷工的记录，但是会有一种情况就是只打下班卡，没有打上班卡、
                //所以还需要查找考勤表中statex=0的状态。可以根据月份和e_id和statex=0；
                T_Attence ta=new T_Attence();
                ta.setA_moth(uptime);
                ta.setA_statex(0);
                ta.setE_id(e_id);
                List<T_Attence> taa=tas.getT_AttenceByStatex(ta);
                //判断statex=0的次数，算出这个职位每天的工资
                double oneDayPay=pay/22;
                //扣除只打上班卡，不打下班卡，从而产生旷工的钱
                double statex0=taa.size()*oneDayPay;
                //每个月缴纳的社保：设定为月工资的4%；
                double sscost1=pay*0.04;
                //每个月的绩效奖金：设定为月工资的5%；
                double bonus1=pay*0.05;
                //求出总薪资
                double allsalary=0;
                if (count>=22){//判断是否考勤大于22天，这是考勤大于22天的总工资
                     allsalary=(-sscost1)+bonus1+(-statex0)+(-state0)+(state1)+pay;
                }else{//这是考勤小于22天工资
                    int xxx=22-count;
                    double pay1=xxx*oneDayPay;
                     allsalary=(-sscost1)+bonus1+(-statex0)+(-state0)+(state1)+pay1;
                }

                T_Salary tsss=new T_Salary();
                tsss.setE_id(e_id);//员工ID
                tsss.setSa_month(uptime);//确定是那个月的薪资
                tsss.setSa_salary(pay);//基本工资
                tsss.setSa_rpcost(state1-state0);//奖惩产生的钱
                tsss.setSa_state(state);//状态
                tsss.setSa_sscost(sscost1);//社保
                tsss.setSa_bonus(bonus1);//奖金
                tsss.setSa_allsalary(allsalary);//总薪资
                boolean falg=tss.saveT_Salary(tsss);
            }
            request.setAttribute("success","薪资结算成功！！！");
            return "manager/m_salary";
        }
    }
}
