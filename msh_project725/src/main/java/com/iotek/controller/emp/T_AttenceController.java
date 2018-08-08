package com.iotek.controller.emp;

import com.iotek.model.T_Attence;
import com.iotek.model.T_Emp;
import com.iotek.model.T_Position;
import com.iotek.model.T_Rwdpen;
import com.iotek.service.T_AttenceService;
import com.iotek.service.T_EmpService;
import com.iotek.service.T_PositionService;
import com.iotek.service.T_RwdpenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/4.
 */
@Controller
public class T_AttenceController {
    @Resource
    private T_AttenceService tas;
    @Resource
    private T_RwdpenService trs;
    @Resource
    private T_EmpService tes;
    @Resource
    private T_PositionService tps;

    //state的状态=0，说明上班卡正常；
    // =1，说明迟到；
    // =2，说明早上旷工；
    // =3，说明早上正常上班，下班早退；
    // =4，说明早上正常上班，下午旷工；
    // =5，说明早上正常上班，下午加班；
    // =10，说明早上正常上班，下午正常下班；
    // =6，说明早上是迟到的，下午早退；
    // =7, 说明早上是迟到的，下午旷工；
    // =8，说明早上是迟到的，下午加班；
    // =9, 说明早上是迟到的，下午是正常下班；
    //关于T_Attence中的字段
    //a_id----考勤表的id
    //a_today ----考勤表的日期
    //a_begintime----上班打卡时间
    //a_endtime-----下班打卡时间
    //a_state-----考勤表的状态
    //e_id----用户id
    //a_statex----只是用来判断用户的打卡情况的，statex=0，只是打了上班卡，在计算薪资的时候算旷工处理；
    //statex=1，打了上班卡，又打了下班卡；
    @RequestMapping("/saveAttence1")
    public String saveAttence1(HttpServletRequest request,HttpSession session){
        //需要判断日期，打的上班卡是不是今天的卡，
        //打上班卡，需要判断是否已经打过上班卡。
        //还需要判断，正常的上班时间和个人的上班打卡时间，
        //获取员工个人的id
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        Date day=new Date();//获取当前时间
        //产生奖惩记录的时候会用到。。。。。
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime=df0.format(day);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//获取今天的日期
        String time1=df1.format(day);//获取今天的日期
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String  time2=df2.format(day);//打卡时间
        //正常上下班时间
        String atime=time1+" 09:00:00";//上班时间为上午9点；
        String btime=time1+" 18:00:00";//下班时为下午18点；上班卡可能用不上。。。。
        String ctime=time1+" 11:00:00";//迟到3小时算旷工；
        String dtime=time1+" 15:00:00";//早退3小时算旷工；上班卡可能用不上。。。。
        //打卡前需要判断这个员工是否迟到或者旷工；就需要对比上班时间和打卡时间比较；
        //如果是迟到还需要对“11:00:00”这个时间对比，判定是不是旷工；
        long nowtime=day.getTime();//打卡时间的毫秒数
        //上班时间毫秒数
        long uptime=0;
        long up3time=0;
        try {
            uptime=df2.parse(atime).getTime();//生成上班时间的毫秒数
            up3time=df2.parse(ctime).getTime();//算出迟到旷工的时间毫秒数
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        //还有一种情况，已经打过卡了，就不能打卡了
        //可以根据日期和员工id判断今天有没有考勤记录
        T_Attence tatt=new T_Attence();
        tatt.setE_id(e_id);
        tatt.setA_today(time1);//今天日期
        T_Attence tatt1=tas.getAttenceByTodayAndE_id(tatt);
        if (tatt1.getA_id()!=0){
            request.setAttribute("tatt","您今天已经打过上班卡了！");
            return "emp/e_empFrist";
        }


        if (nowtime<uptime){//正常上班
            //添加考勤记录，不产生奖惩
            T_Attence ta=new T_Attence();
            ta.setA_moth(mtime);//月份
            ta.setA_today(time1);//日期
            ta.setA_begintime(time2);//打卡时间
            ta.setA_endtime("0");//没有下班时间
            ta.setA_statex(0);//产生上班打卡的情况
            ta.setA_state(0);//state=0说明是考勤正常。
            ta.setE_id(e_id);
            boolean falg=tas.saveAttence(ta);
            request.setAttribute("state0","打卡成功，开始愉快的一天工作！");
            return "emp/e_empFrist";
        }else if (uptime<nowtime&&nowtime<up3time){
            //添加考勤记录，产生奖惩记录，迟到
            T_Attence ta=new T_Attence();
            ta.setA_moth(mtime);//月份
            ta.setA_today(time1);//日期
            ta.setA_begintime(time2);//打卡时间
            ta.setA_endtime("0");//没有下班时间
            ta.setA_statex(0);//产生上班打卡的情况
            ta.setA_state(1);//state=1说明是考勤是迟到的状态。
            ta.setE_id(e_id);//获取员工id
            boolean falg=tas.saveAttence(ta);
            //增加奖惩记录
            T_Rwdpen tr=new T_Rwdpen();
            tr.setE_id(e_id);//获取员工id
            //这里还需要获取员工的基本薪资，迟到扣出当天工资的25%；
            //现实找到职位，然后查看职位基本薪资
            T_Emp t1=new T_Emp();
            t1.setE_id(e_id);
            T_Emp t2=tes.getT_Emp(t1);//通过e_id查找员工信息
            T_Position tp1=new T_Position();
            tp1.setP_id(t2.getP_id());
            T_Position tp2=tps.get_PostionByid(tp1);//通过p_id查找职位信息
            double money=tp2.getP_pay();//得到基本薪资
            double money1=money/22*0.4;//当天工资的25%；
            tr.setRp_money(money1);//扣除的钱
            tr.setRp_moth(mtime);//奖惩产生的月份
            tr.setRp_time(time1);//奖惩记录产生的日期
            tr.setRp_reason("上班迟到");//奖惩记录产生的原因
            boolean falg1=trs.saveRwdpen(tr);
            request.setAttribute("state1","打卡成功，您今天迟到了,开始愉快的一天工作！");
            return "emp/e_empFrist";
        }else{
            //添加考勤记录，产生奖惩记录，旷工
            T_Attence ta=new T_Attence();
            ta.setA_moth(mtime);//月份
            ta.setA_today(time1);//日期
            ta.setA_begintime(time2);//打卡时间
            ta.setA_endtime("0");//没有下班时间
            ta.setA_statex(0);//产生上班打卡的情况
            ta.setA_state(2);//state=1说明是考勤是旷工的状态。
            ta.setE_id(e_id);//获取员工id
            boolean falg=tas.saveAttence(ta);
            //增加奖惩记录
            T_Rwdpen tr=new T_Rwdpen();
            tr.setE_id(e_id);//获取员工id
            //这里还需要获取员工的基本薪资，旷工扣出当天工资；
            //现实找到职位，然后查看职位基本薪资
            T_Emp t1=new T_Emp();
            t1.setE_id(e_id);
            T_Emp t2=tes.getT_Emp(t1);//通过e_id查找员工信息
            T_Position tp1=new T_Position();
            tp1.setP_id(t2.getP_id());
            T_Position tp2=tps.get_PostionByid(tp1);//通过p_id查找职位信息
            double money=tp2.getP_pay();//得到基本薪资
            double money1=money/22;//当天工资；
            tr.setRp_money(money1);//扣除的钱
            tr.setRp_moth(mtime);//奖惩产生的月份
            tr.setRp_time(time1);//奖惩记录产生的日期
            tr.setRp_reason("旷工");//奖惩记录产生的原因
            tr.setRp_state(0);//state=0;说明是惩罚
            boolean falg1=trs.saveRwdpen(tr);
            request.setAttribute("state2","打卡成功，但是已经旷工了,滚回去睡觉吧！明天早点来！");
            return "emp/e_empFrist";
        }
    }
    @RequestMapping("/updateAttenceEndtime")
    public String updateAttenceEndtime(HttpSession session,HttpServletRequest request){
        T_Emp e= (T_Emp) session.getAttribute("emp");
        int e_id=e.getE_id();//获取到了员工id
        T_Emp t1=new T_Emp();
        t1.setE_id(e_id);
        T_Emp t2=tes.getT_Emp(t1);//通过e_id查找员工信息
        T_Position tp1=new T_Position();
        tp1.setP_id(t2.getP_id());
        T_Position tp2=tps.get_PostionByid(tp1);//通过p_id查找职位信息
        double money=tp2.getP_pay();//得到基本薪资
        double money1=money/22;//当天工资；


        Date day=new Date();//获取当前时间
        //产生奖惩记录的时候会用到。。。。。
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime=df0.format(day);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//获取今天的日期
        String time1=df1.format(day);//获取今天的日期
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String  time2=df2.format(day);//打卡时间
        //正常上下班时间
        String atime=time1+" 09:00:00";//上班时间为上午9点；
        String btime=time1+" 18:00:00";//下班时为下午18点；
        String ctime=time1+" 11:00:00";//迟到3小时算旷工；
        String dtime=time1+" 15:00:00";//早退3小时算旷工；
        String etime=time1+" 19:00:00";//加班的时间节点；
        //打卡前需要判断这个员工是否迟到或者旷工；就需要对比上班时间和打卡时间比较；、
        long a=day.getTime();//下班的打卡时间的毫秒数
        long downtime=0;
        long down_3time=0;
        long down1time=0;
        try {
            downtime=df2.parse(btime).getTime();//生成下班时间的毫秒数
            down_3time=df2.parse(dtime).getTime();//算出早退旷工的时间毫秒数
            down1time=df2.parse(etime).getTime();//算出加班时间点的时间毫秒数
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        //在打下班卡之前先判断是否有打过上班卡
        T_Attence tatt=new T_Attence();
        tatt.setE_id(e_id);
        tatt.setA_today(time1);//今天日期
        T_Attence tatt1=tas.getAttenceByTodayAndE_id(tatt);
        if (tatt1.getA_id()!=0){//说明今天有上班卡，可以打下班卡
            //先是需要改变statex的状态，将其状态改为=1；
            //statex=1，是说明有完整的上下班卡
            T_Attence ta11=new T_Attence();
            int aid=tatt1.getA_id();//根据日期和e_id查找今天的考勤记录的id，修改statex的状态；
            ta11.setA_id(aid);
            ta11.setA_statex(1);
            //修改statex的状态，statex的状态体现了打卡的完整性。
            boolean falgx=tas.updateAttenceStatex(ta11);



            //有了上班卡的的三种状态：
            //1：正常上班state=0；下班卡会出现早退，旷工（早退提前3个小时）
            //2：迟到上班state=1；下班卡会出现早退，旷工（早退提前3个小时）
            //3：旷工上班state=2：下班卡不用打了，在打上班卡的时候就产生奖惩。
            //还会有一种情况，打过一次下班卡，之后又打下班卡。。。。
            //在打下班卡的时候需要判断是否有下班卡
            if (tatt1.getA_endtime().equals("0")){//如果下班是显示为“0”，说明是这是第一次打下班卡
                //生成今天的奖惩，生成今天的考勤
                T_Attence ta1=new T_Attence();
                int a_id=tatt1.getA_id();//根据日期和e_id查找今天的考勤记录的id，修改下班时间；
                ta1.setA_id(a_id);
                ta1.setA_endtime(time2);
                boolean falg1=tas.updateAttenceEndtime(ta1);//生成了今天的考勤
                //根据今天的考勤，生成奖惩，因为打上班卡的时候生成过状态，state的状态，所以根据时间还需要修改状态
                //1、首先先要再查一下今天的考勤，因为刚刚生成了下班时间。
                T_Attence a1=tas.getAttenceByTodayAndE_id(tatt);
                int state=a1.getA_state();
                if (state==0){//属于正常上班，然后在判断下班的打卡时间。

                    //这里需要考虑加班的条件，超过下班卡一个小时，算加班的，改变状态state=5；

                    if(a>=downtime&&a<down1time){//属于正常的上下班，无奖惩的产生。改变装state=10；
                        a1.setA_state(10);
                        //正常的上下班，改变状态state=10；
                        boolean falg=tas.updateAttenceState(a1);
                        request.setAttribute("success1","第一次下班卡打卡成功，忙了一天，辛苦了！");
                        return "emp/e_empFrist";
                    }else if (a>=down1time){//属于加班，有奖惩的产生，改变状态state=5；
                        T_Attence a2=new T_Attence();
                        a2.setA_state(5);
                        a2.setA_id(a1.getA_id());
                        boolean falg2=tas.updateAttenceState(a2);//将打上班卡的状态改成state=5；
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr.setRp_money(money1+x*100);//
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("加班");//奖惩记录产生的原因
                        tr.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，加班辛苦了！");
                        return "emp/e_empFrist";

                    }else if (a>=down_3time&&a<downtime){//打卡时间小于正常下班时间，大于旷工时间点，属于早退
                        T_Attence a2=new T_Attence();
                        a2.setA_state(3);
                        a2.setA_id(a1.getA_id());
                        boolean falg2=tas.updateAttenceState(a2);//将打上班卡的状态改成state=3；
                        //生成奖惩记录，需要罚款，state=0，处罚；
                          //增加奖惩记录
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        double money2=money1*0.4;//当天工资的25%；
                        tr.setRp_money(money2);//扣除的钱
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//奖惩记录产生的原因
                        tr.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，现在打卡是算早退的！");
                        return "emp/e_empFrist";

                    }else{//a<down_3time,说明是下班旷工，state=4，下班旷工
                        T_Attence a2=new T_Attence();
                        a2.setA_state(4);
                        a2.setA_id(a1.getA_id());
                        boolean falg2=tas.updateAttenceState(a2);//将打上班卡的状态改成state=4；
                        //生成奖惩记录，需要罚款，state=0，处罚；
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id

                        tr.setRp_money(money1);//扣除的钱 =当天工资；
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//奖惩记录产生的原因
                        tr.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，现在打卡是算旷工的！");
                        return "emp/e_empFrist";
                    }
                }else if(state==1){//state=1，说明的是就是迟到上班
                    //首先上班时迟到的，如果下班是迟到的那么就需要产生惩罚，今天就有两个惩罚state=6
                    //然后就是上班时迟到的，下班是旷工的，产生旷工惩罚，两个惩罚记录state=7，只扣旷工的钱；
                    //最后就是上班时迟到，下班是加班的，产生奖励记录，两个记录；stae=8
                    //还有一个正常的，不产生奖惩记录，state=9；
                    if (a>=downtime&&a<down1time){//这个时间段说明，正常的下班时间，state=9，迟到上班和正常下班；
                        a1.setA_state(9);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为9；
                        request.setAttribute("success1","第一次下班卡打卡成功，上班迟到，下班卡正常！");
                        return "emp/e_empFrist";

                    }else if (a>=down1time){//满足这个条件，说明是加班的状态，state=8，迟到上班和加班下班；
                        a1.setA_state(8);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为8；
                        //生成奖励记录
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr.setRp_money(money1+x*100);//
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("加班");//奖惩记录产生的原因
                        tr.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，上班迟到，下班卡是加班！");
                        return "emp/e_empFrist";
                    }else if (a>=down_3time&&a<downtime){//这个时间段属于早退的状态，上班迟到，下班早退，state=6；
                        a1.setA_state(6);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为6；
                        //生成奖惩记录，需要罚款，state=0，处罚；
                        //增加奖惩记录
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        double money2=money1*0.4;//当天工资的25%；
                        tr.setRp_money(money2);//扣除的钱
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//奖惩记录产生的原因
                        tr.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，上班迟到，下班卡是早退卡！");
                        return "emp/e_empFrist";
                    }else{//a<down_3time,说明是下班旷工，state=7，下班旷工
                        a1.setA_state(7);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为7；
                        //生成奖惩记录，现在打卡旷工的状态
                        //生成奖惩记录，需要罚款，state=0，处罚；
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id

                        tr.setRp_money(money1);//扣除的钱 =当天工资；
                        tr.setRp_moth(mtime);//奖惩产生的月份
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//奖惩记录产生的原因
                        tr.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr);
                        request.setAttribute("success1","第一次下班卡打卡成功，上班迟到，下班卡是旷工！");
                        return "emp/e_empFrist";
                    }
                }else{//上午旷工的员工打下班卡
                    request.setAttribute("success1","第一次下班卡打卡成功，上班旷工，打卡无效！");
                    return "emp/e_empFrist";
                }
            }else{//end_time是有的，不为0；
                //说明之前生成过奖惩，生成过考勤，现在只需要修改奖惩和考勤
                T_Attence ta1=new T_Attence();
                int a_id=tatt1.getA_id();//根据日期和e_id查找今天的考勤记录的id，修改下班时间；
                ta1.setA_id(a_id);
                ta1.setA_endtime(time2);
                boolean falg1=tas.updateAttenceEndtime(ta1);//生成了今天的考勤
                //1、首先先要再查一下今天的考勤，因为刚刚生成了下班时间。
                T_Attence a1=tas.getAttenceByTodayAndE_id(tatt);
                int state=a1.getA_state();
                if (state==3){//这个状态说明的是，上班卡正常，下班卡目前的状态是早退
                    //之后的再次打下班卡的话就会有三种状态改变，state=3,10,5；
                    //至于奖惩表就需要将之前的奖惩根据现在的状态进行修改；
                    if (a<downtime){//因为是的状态state=3，所以只需要判断是否大于下班时间
                        //这个打卡时间还是小于下班时间，状态还是state=3;只需要修改打卡时间，维持之前的奖惩；
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班早退！");
                        return "emp/e_empFrist";

                    }else if (a>=downtime&&a<down1time){//上班卡正常，下班卡是正常了
                        //将状态改变为state=10；
                        a1.setA_state(10);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为10；
                        //对于奖惩来说，需要删除之前的早退惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班正常！");
                        return "emp/e_empFrist";
                    }else{//这个状态就是加班的情况，删除之前的早退惩罚，增加加班奖励，将state改为=5；
                        //将状态改变为state=5；
                        a1.setA_state(5);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为5；
                        //对于奖惩来说，需要删除之前的早退惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班加班！");
                        return "emp/e_empFrist";
                    }
                }else if (state==4){//上班正常，下班是旷工，之后在打卡有4中状态
                    //state=4/3/10/5，分别为旷工，早退，正常，加班
                    if (a>=downtime&&a<down1time){//正常下班，state=10,将之前生成的惩罚删除；
                        //将状态改变为state=10；
                        a1.setA_state(10);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为10；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班正常！");
                        return "emp/e_empFrist";
                    }else if (a>=down_3time&&a<downtime){//下班时早退，将state的状态改为3；
                        //将状态改变为state=3；
                        a1.setA_state(3);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为3；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成新的惩罚，惩罚为早退
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        double money2=money1*0.4;//当天工资的25%；
                        tr1.setRp_money(money2);//扣除的钱
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("下班早退");//奖惩记录产生的原因
                        tr1.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班早退！");
                        return "emp/e_empFrist";
                    }else if(a>=down1time){//加班的状态了，将state=5；
                        //将状态改变为state=5；
                        a1.setA_state(5);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为5；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班加班！");
                        return "emp/e_empFrist";
                    }else{//不做改变，维持之前第一次的修改。
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班旷工！");
                        return "emp/e_empFrist";
                    }
                }else if (state==5){//这个状态只能继续加班了，state=5，不做改变，奖励做出修改
                    //对于奖惩来说，需要删除之前的加班奖励。可以根据日期，员工id，原因来删除
                    T_Rwdpen tr=new T_Rwdpen();
                    tr.setE_id(e_id);//获取员工id
                    tr.setRp_time(time1);//奖惩记录产生的日期
                    tr.setRp_reason("加班");//之前的原因是对应的
                    boolean falg2=trs.deleteRwdpen(tr);
                    //生成奖励的记录，根据时间判断加班多久。
                    //生成奖惩记录，需要奖励工资，state=1，奖励。
                    T_Rwdpen tr1=new T_Rwdpen();
                    tr1.setE_id(e_id);//获取员工id
                    //这里还需要获取员工的基本薪资，算出加班工资；
                    //加班工资100元每小时
                    //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                    long onehour=1000*60*60;
                    int x= (int) ((a-down1time)/onehour);
                    tr1.setRp_money(money1+x*100);//
                    tr1.setRp_moth(mtime);//奖惩产生的月份
                    tr1.setRp_time(time1);//奖惩记录产生的日期
                    tr1.setRp_reason("加班");//奖惩记录产生的原因
                    tr1.setRp_state(1);//state=1;说明是奖励
                    boolean falg3=trs.saveRwdpen(tr1);
                    request.setAttribute("x1","下班卡打卡成功，上班正常，下班加加班！");
                    return "emp/e_empFrist";
                }else if (state==10){//这个状态之后打卡只能有两种状态，正常下班或者加班
                    if (a>=downtime&&a<down1time){//这个时间状态在加班之前，正常打卡之后，还是属于正常，不做改变
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班正常！");
                        return "emp/e_empFrist";
                    }else{//a>down1time,改变状态state=5，将生成加班奖励
                        //将状态改变为state=5；
                        a1.setA_state(5);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为5；
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("x1","下班卡打卡成功，上班正常，下班加班！");
                        return "emp/e_empFrist";
                    }
                }else if(state==6){//上班的时候是迟到的，下班是早退的，根据时间修改状态。
                    if (a<downtime){//因为是的状态state=6，所以只需要判断是否大于下班时间
                        //这个打卡时间还是小于下班时间，状态还是state=6;只需要修改打卡时间，维持之前的奖惩；
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班早退！");
                        return "emp/e_empFrist";

                    }else if (a>=downtime&&a<down1time){//上班卡迟到，下班卡是正常了
                        //将状态改变为state=9；
                        a1.setA_state(9);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为9；
                        //对于奖惩来说，需要删除之前的早退惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班正常！");
                        return "emp/e_empFrist";
                    }else{//这个状态就是加班的情况，删除之前的早退惩罚，增加加班奖励，将state改为=8；
                        //将状态改变为state=8；
                        a1.setA_state(8);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为8；
                        //对于奖惩来说，需要删除之前的早退惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班早退");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班加班！");
                        return "emp/e_empFrist";
                    }
                }else if (state==7){//这个状态会有很多的情况
                    //state=7/6/9/8，分别为旷工，早退，正常，加班
                    if (a>=downtime&&a<down1time){//正常下班，state=9,将之前生成的惩罚删除；
                        //将状态改变为state=9；
                        a1.setA_state(9);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为9；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班正常！");
                        return "emp/e_empFrist";
                    }else if (a>=down_3time&&a<downtime){//下班时早退，将state的状态改为6；
                        //将状态改变为state=6；
                        a1.setA_state(6);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为6；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下午旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成新的惩罚，惩罚为早退
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        double money2=money1*0.4;//当天工资的25%；
                        tr1.setRp_money(money2);//扣除的钱
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("下班早退");//奖惩记录产生的原因
                        tr1.setRp_state(0);//state=0;说明是处罚
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班早退！");
                        return "emp/e_empFrist";
                    }else if(a>=down1time){//加班的状态了，将state=8；
                        //将状态改变为state=8；
                        a1.setA_state(8);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为8；
                        //对于奖惩来说，需要删除之前的旷工惩罚。可以根据日期，员工id，原因来删除
                        T_Rwdpen tr=new T_Rwdpen();
                        tr.setE_id(e_id);//获取员工id
                        tr.setRp_time(time1);//奖惩记录产生的日期
                        tr.setRp_reason("下班旷工");//之前的原因是对应的
                        boolean falg2=trs.deleteRwdpen(tr);
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班加班！");
                        return "emp/e_empFrist";
                    }else{//不做改变，维持之前第一次的修改。
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班旷工！");
                        return "emp/e_empFrist";
                    }
                }else if(state==8){//这个状态只能继续加班了，state=8，不做改变，奖励做出修改
                    //对于奖惩来说，需要删除之前的加班奖励。可以根据日期，员工id，原因来删除
                    T_Rwdpen tr=new T_Rwdpen();
                    tr.setE_id(e_id);//获取员工id
                    tr.setRp_time(time1);//奖惩记录产生的日期
                    tr.setRp_reason("加班");//之前的原因是对应的
                    boolean falg2=trs.deleteRwdpen(tr);
                    //生成奖励的记录，根据时间判断加班多久。
                    //生成奖惩记录，需要奖励工资，state=1，奖励。
                    T_Rwdpen tr1=new T_Rwdpen();
                    tr1.setE_id(e_id);//获取员工id
                    //这里还需要获取员工的基本薪资，算出加班工资；
                    //加班工资100元每小时
                    //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                    long onehour=1000*60*60;
                    int x= (int) ((a-down1time)/onehour);
                    tr1.setRp_money(money1+x*100);//
                    tr1.setRp_moth(mtime);//奖惩产生的月份
                    tr1.setRp_time(time1);//奖惩记录产生的日期
                    tr1.setRp_reason("加班");//奖惩记录产生的原因
                    tr1.setRp_state(1);//state=1;说明是奖励
                    boolean falg3=trs.saveRwdpen(tr1);
                    request.setAttribute("y1","下班卡打卡成功，上班迟到，下班加加班！");
                    return "emp/e_empFrist";
                }else{//state==9;//这个状态之后打卡只能有两种状态，正常下班或者加班
                    if (a>=downtime&&a<down1time){//这个时间状态在加班之前，正常打卡之后，还是属于正常，不做改变
                        request.setAttribute("y1","下班卡打卡成功，上班迟到，下班正常！");
                        return "emp/e_empFrist";
                    }else{//a>down1time,改变状态state=8，将生成加班奖励
                        //将状态改变为state=8；
                        a1.setA_state(8);
                        boolean falg=tas.updateAttenceState(a1);//将state的状态改为8；
                        //生成奖励的记录，根据时间判断加班多久。
                        //生成奖惩记录，需要奖励工资，state=1，奖励。
                        T_Rwdpen tr1=new T_Rwdpen();
                        tr1.setE_id(e_id);//获取员工id
                        //这里还需要获取员工的基本薪资，算出加班工资；
                        //加班工资100元每小时
                        //需要算出加班多久的时间，加班时间除以一小时的毫秒数，算出加多小时班
                        long onehour=1000*60*60;
                        int x= (int) ((a-down1time)/onehour);
                        tr1.setRp_money(money1+x*100);//
                        tr1.setRp_moth(mtime);//奖惩产生的月份
                        tr1.setRp_time(time1);//奖惩记录产生的日期
                        tr1.setRp_reason("加班");//奖惩记录产生的原因
                        tr1.setRp_state(1);//state=1;说明是奖励
                        boolean falg3=trs.saveRwdpen(tr1);
                        request.setAttribute("y1","下班卡打卡成功，上班正常，下班加班！");
                        return "emp/e_empFrist";
                    }
                }
            }
        }else{
            request.setAttribute("nobegintime","您没有打上班卡，不能打下班卡");
            return "emp/e_empFrist";
        }
    }
    //管理员查看考勤
    @RequestMapping("/m_attence")
    public String m_attence(int currentPage,HttpServletRequest request){
        List<T_Attence> ta=tas.getAllAttence();
        if (ta.size()!=0){
            int totalRows = ta.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);


            List<T_Attence> tat=tas.get_AllAttenceCuu(data);
            request.setAttribute("tat", tat);
            request.setAttribute("totalPages",totalPages);

            return  "manager/m_getAttence";
        }else{
            request.setAttribute("notAttence","暂时没有考勤记录");
            return  "manager/m_getAttence";
        }
    }
}
