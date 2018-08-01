package com.iotek.controller.manager;

import com.iotek.model.T_Manager;
import com.iotek.service.T_ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/7/30.
 */
@Controller
public class T_ManagerController {
    @Resource
    private T_ManagerService tms;
    @RequestMapping("/managerlogin")
    public String managerLogin(T_Manager t_manager, HttpServletRequest request)throws  Exception{
        if(t_manager.getM_name()==""||t_manager.getM_password()==""){
            request.setAttribute("tm","用户名密码不能为空");
            return "../../Login";
        }
        T_Manager t_manager1=tms.getManager(t_manager);
        if (t_manager1!=null){
            request.setAttribute("t_manager1",t_manager1);
            return "manager/manager";
        }else{
            request.setAttribute("tm1","用户名密码错误");
            return "../../Login";
        }
    }
}
