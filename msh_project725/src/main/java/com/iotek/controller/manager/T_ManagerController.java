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

            return "manager/manager";
        }

        return "manager/manager";
    }
}
