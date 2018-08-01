package com.iotek.controller.manager;

import com.iotek.model.T_Dept;
import com.iotek.model.T_Emp;
import com.iotek.service.T_DeptService;
import com.iotek.service.T_EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
@Controller
public class T_DeptController {
    @Resource
    private T_DeptService tds;
    @Resource
    private T_EmpService tes;
    @RequestMapping("/getdept")
    public String  getTdeptsAll(int currentPage,HttpServletRequest request)throws Exception{
        List<T_Dept> tDepts=tds.getTdeptAll();
        if (tDepts.size()!=0) {
            int totalRows = tDepts.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);


            List<T_Dept> tDeptss = tds.getT_deptsAll(data);
            request.setAttribute("tDepts", tDeptss);
            request.setAttribute("totalPages",totalPages);
            return "manager/m_getdept";
        }else{
            request.setAttribute("nodept","还未添加任何部门");
            return "manager/m_deptAndpos";
        }
    }
    //修改部门名称
    @RequestMapping("/updateDept")
    public String updateDept(int d_id,HttpServletRequest request){
        T_Dept tDept=new T_Dept();
        tDept.setD_id(d_id);
        T_Dept tDept1=tds.getT_DeptByid(tDept);
        request.setAttribute("dept",tDept1);
        return "manager/m_updateDept";

    }
    @RequestMapping("/updateDept2")
    public String updateDept(T_Dept t_dept,HttpServletRequest request)throws Exception{
        System.out.println(t_dept);
        boolean falg=tds.updateT_Dept(t_dept);
        int currentPage=1;
        return getTdeptsAll( currentPage, request);
    }
    //删除部门
    @RequestMapping("/deleteDept")
    public String deleteDept(int d_id,HttpServletRequest request)throws Exception{
        int currentPage=1;
        T_Emp tEmp=new T_Emp();
        tEmp.setD_id(d_id);
        List<T_Emp> t_emps=tes.getT_EmpByd_id(tEmp);
        if (t_emps.size()!=0){
            request.setAttribute("nodelete","该部门有员工，无法删除");
            return getTdeptsAll( currentPage, request);
        }else{
            T_Dept tDept=new T_Dept();
            tDept.setD_id(d_id);
            boolean falg=tds.deleteT_Dept(tDept);
            return getTdeptsAll( currentPage, request);
        }
    }
    //跳转部门信息添加页面
    @RequestMapping("/savedept")
    public String savedept(){
        return "manager/m_savedept";
    }
    //后台实现部门信息添加
    @RequestMapping("/savedept11")
    public String saveDept1(String d_name,HttpServletRequest request)throws Exception{
        T_Dept tDept=new T_Dept();
        tDept.setD_name(d_name);
        T_Dept tDept1=tds.getT_Dept(tDept);
        System.out.println(tDept);
        if (tDept1!=null){
            request.setAttribute("dept1","这个部门已经存在");
            return "manager/m_savedept";
        }else{
            boolean falg=tds.saveT_Dept(tDept);
            int currentPage=1;
            return getTdeptsAll( currentPage, request);
        }
    }
}
