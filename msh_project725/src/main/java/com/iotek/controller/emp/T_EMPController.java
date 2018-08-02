package com.iotek.controller.emp;

import com.iotek.model.T_Emp;
import com.iotek.service.T_EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/8/2.
 */
@Controller
public class T_EMPController {
    @Resource
    private T_EmpService tes;
    //员工登录
    @RequestMapping("/emplogin")
    public String emplogin(T_Emp t_emp, HttpServletRequest request)throws Exception{
        if (t_emp.getE_num()==""||t_emp.getE_password()==""){
            request.setAttribute("noemp","账号和密码不能为空");
            return "../../emp";
        }
        T_Emp tEmp=tes.getEmpByNumAndPassword(t_emp);
        if (tEmp!=null){
            return "emp/empFrist";
        }else{
            request.setAttribute("noemp1","账号和密码错误！");
            return "../../emp";
        }
    }
}
