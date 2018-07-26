package com.iotek.controller;

import com.iotek.model.T_Recruit;
import com.iotek.model.T_Tourist;
import com.iotek.service.T_RecruitService;
import com.iotek.service.T_TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */
@Controller
public class T_TouristController {
    @Resource
    private T_TouristService ts;
    @Resource
    private T_RecruitService trs;
    @RequestMapping("/recruit")
    public String getRecruit(HttpServletRequest request){
        T_Recruit tRecruit=new T_Recruit();
        tRecruit.setR_state(2);
        List<T_Recruit> recruits=trs.getRecruits(tRecruit);
        if (recruits!=null){
            request.setAttribute("recruitlist",recruits);
            return "recruit";
        }else{
            request.setAttribute("norecruits","暂时没有发布任何职位！");
            return "recruit";
        }
    }
    @RequestMapping("/login")
    public String login(T_Tourist t_tourist, HttpServletRequest request){
        T_Tourist tourist=ts.getLogin(t_tourist);

        if(t_tourist.getT_name()==""||t_tourist.getT_password()==""){
            request.setAttribute("tt","用户名密码不能为空");

            return "../../index";
        }
        if (tourist!=null){
            request.setAttribute("ts",tourist);
            return getRecruit(request);
        }else{
            request.setAttribute("ts","用户名密码错误");
            return "../../index";
        }
    }
    @RequestMapping("/res")
    public String register(T_Tourist t_tourist,HttpServletRequest request){
        T_Tourist tourist=ts.getTouristById(t_tourist);
        if (tourist!=null){
            request.setAttribute("re","用户名已经被注册！");
            return "../../register";
        }else{
            boolean falg=ts.register(t_tourist);
            request.setAttribute("re1","恭喜，注册成功！");
            return "../../register";
        }
    }
}
