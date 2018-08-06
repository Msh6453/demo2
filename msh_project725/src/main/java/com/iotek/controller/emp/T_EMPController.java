package com.iotek.controller.emp;

import com.iotek.model.T_Emp;
import com.iotek.service.T_EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/8/2.
 */
@Controller
public class T_EMPController {
    @Resource
    private T_EmpService tes;
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
            request.setAttribute("success",tEmp);
            session.setAttribute("emp",tEmp);
            return "emp/e_empFrist";
        }else{
            request.setAttribute("noemp1","账号和密码错误！");
            return "../../emp";
        }
    }
}
