package com.iotek.controller.manager;

import com.iotek.model.T_Position;
import com.iotek.service.T_PositionService;
import org.springframework.asm.Handle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Controller
public class T_PositionController {
    @Resource
    private T_PositionService tps;
    @RequestMapping("/getPosition")
    @ResponseBody
    public Object getPosition(int d_id){
        T_Position t_position=new T_Position();
        t_position.setD_id(d_id);
        List<T_Position> t_positions=tps.getPositions(t_position);
        System.out.println(t_positions);
        return t_positions;
    }
}
