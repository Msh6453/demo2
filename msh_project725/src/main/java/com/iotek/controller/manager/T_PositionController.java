package com.iotek.controller.manager;

import com.iotek.model.T_Dept;
import com.iotek.model.T_Emp;
import com.iotek.model.T_Position;
import com.iotek.service.T_DeptService;
import com.iotek.service.T_EmpService;
import com.iotek.service.T_PositionService;
import org.springframework.asm.Handle;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class T_PositionController {
    @Resource
    private T_PositionService tps;
    @Resource
    private T_DeptService tds;
    @Resource
    private T_EmpService tes;

    @RequestMapping("/getPosition")
    @ResponseBody
    public Object getPosition(int d_id)throws Exception{
        T_Position t_position=new T_Position();
        t_position.setD_id(d_id);
        List<T_Position> t_positions=tps.getPositions(t_position);
        System.out.println(t_positions);
        return t_positions;
    }
    //查看所有职位
    @RequestMapping("/getpos")
    public String getpos(int currentPage,HttpServletRequest request)throws Exception{
        List<T_Position> tPositions=tps.getT_Positions();

        if (tPositions.size()!=0) {
            int totalRows = tPositions.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);


            List<T_Position> t_positions = tps.getT_Positionss(data);
            request.setAttribute("t_positions", t_positions);
            request.setAttribute("tds",tds);
            request.setAttribute("totalPages",totalPages);


            return "manager/m_getPositions";
        }else{
            request.setAttribute("noposition","还没有添加任何职位");
            return "manager/m_deptAndpos";
        }
    }
    //修改职位名称1，显示跳转到修改页面，然后代码修改
    @RequestMapping("/updatePos1")
    public String updatePos1(int p_id, HttpServletRequest request)throws Exception{
        T_Position t=new T_Position();
        t.setP_id(p_id);
        T_Position tPosition=tps.get_PostionByid(t);
        request.setAttribute("tP",tPosition);
        return "manager/m_updatePos1";
    }
    @RequestMapping("/updatePos2")
    public  String updatePos2( T_Position t_position,HttpServletRequest request)throws Exception{
         boolean falg=tps.updateT_Pos(t_position);
        int currentPage=1;
        return getpos( currentPage,request);
    }
    //删除职位，先需要判断该职位是否有人存在，没人就可以直接删除，有人不能删除
    @RequestMapping("/deletePos")
    public String deletePos(int p_id,HttpServletRequest request)throws Exception{
        T_Position f=new T_Position();
        f.setP_id(p_id);
        T_Emp tEmp=new T_Emp();
        tEmp.setP_id(p_id);
        List<T_Emp> t_emps=tes.getT_EmpByp_id(tEmp);
        if (t_emps.size()!=0){
            request.setAttribute("pos","该职位还有人任职，不能删除");
            int currentPage=1;
            return getpos( currentPage,request);
        }else{
            boolean falg=tps.deleteT_Pos(f);
            int currentPage=1;
            return getpos( currentPage,request);
        }
    }
    //先是跳转到增加页面
    @RequestMapping("/savepos1")
    public String savepos1(HttpServletRequest request)throws Exception{
        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tD",tDepts);
        return "manager/m_savepos1";
    }
    //增加的职位，先确定在那个部门添加职位，并且判断该部门中的职位名是否重复
    @RequestMapping("/savePos2")
    public  String savePos2(T_Position t_position,HttpServletRequest request)throws Exception{
        if (t_position.getD_id()==0){
            request.setAttribute("nod_id","请选择部门!");
            return  savepos1( request);
        }
        //先判断重名
        T_Position t=tps.getT_posByName(t_position);
        if (t!=null){
            request.setAttribute("yespos","已经有该职位了!");
            return  savepos1( request);
        }else{
            boolean falg=tps.saveT_Pos(t_position);
            int currentPage=1;
            return getpos( currentPage,request);
        }
    }
}
