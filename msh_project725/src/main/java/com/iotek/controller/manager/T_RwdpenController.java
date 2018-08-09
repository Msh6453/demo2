package com.iotek.controller.manager;

import com.iotek.model.T_Dept;
import com.iotek.model.T_Emp;
import com.iotek.model.T_Rwdpen;
import com.iotek.service.T_DeptService;
import com.iotek.service.T_EmpService;
import com.iotek.service.T_RwdpenService;
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
 * Created by Administrator on 2018/8/6.
 */
@Controller
public class T_RwdpenController {
    @Resource
    private T_RwdpenService trs;
    @Resource
    private T_DeptService tds;
    @Resource
    private T_EmpService tes;
    //跳转到
    @RequestMapping("/m_rwdpen")
    public String m_rwdpen(){
        return "manager/m_rwdpen";
    }
    //跳转到信息添加页面
    @RequestMapping("/saveRwdpen")
    public String saveRwdpen(HttpServletRequest request){
        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tDepts",tDepts);
        return "manager/saveRwdpen2";
    }
    //添加奖惩
    @RequestMapping("/saveRwdpen2")
    public String saveRwdpen2(T_Rwdpen t_rwdpen,int d_id,int p_id,HttpServletRequest request)throws Exception {
        if (t_rwdpen.getRp_money()==0||t_rwdpen.getRp_reason()==""){
            request.setAttribute("noxx","奖惩金额或原因不能为空！");
            return saveRwdpen(request);
        }
        if (d_id==0||p_id==0){
            request.setAttribute("noid","请选择部门和职位！");
            return saveRwdpen(request);
        }
        System.out.println(t_rwdpen);


        //先是通过部门id和职位id查找出员工id
        T_Emp te = new T_Emp();
        te.setD_id(d_id);
        te.setP_id(p_id);
        T_Emp tEmp = tes.getEmpByPidAndDid(te);
        if (tEmp==null){
            request.setAttribute("noemp","该职位没有员工！");
            return saveRwdpen(request);
        }
        int eid = tEmp.getE_id();
        Date day = new Date();//获取当前时间
        //产生奖惩记录的时候会用到。。。。。
        SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM");//获取今天的月份
        String mtime = df0.format(day);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//获取今天的日期
        String time1 = df1.format(day);//获取今天的日期
        T_Rwdpen tr = new T_Rwdpen();
        tr.setE_id(eid);
        tr.setRp_moth(mtime);
        tr.setRp_time(time1);
        tr.setRp_reason(t_rwdpen.getRp_reason());
        tr.setRp_state(t_rwdpen.getRp_state());
        tr.setRp_money(t_rwdpen.getRp_money());
        boolean falg = trs.saveRwdpen(tr);
        request.setAttribute("success","添加奖惩成功！");
        return "manager/m_rwdpen";
    }
    //查看所有人的奖惩
    @RequestMapping("/m_getRwdpen")
    public String m_getRwdpen(int currentPage,HttpServletRequest request){
        List<T_Rwdpen> tr1=trs.getT_RwdpenByAll();
        if (tr1.size()!=0){
            int totalRows = tr1.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);

            List<T_Rwdpen> tr2=trs.getT_RwdpenByAllCurr(data);
            request.setAttribute("tr2", tr2);
            request.setAttribute("totalPages",totalPages);
            return "manager/m_getRwdpen";
        }else{
            request.setAttribute("noRwdpen","暂时没有奖惩记录");
            return "manager/m_rwdpen";
        }
    }
}
