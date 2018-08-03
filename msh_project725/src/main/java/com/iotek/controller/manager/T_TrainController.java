package com.iotek.controller.manager;

import com.iotek.model.T_Dept;
import com.iotek.model.T_Emp;
import com.iotek.model.T_Emp_Train;
import com.iotek.model.T_Train;
import com.iotek.service.T_DeptService;
import com.iotek.service.T_EmpService;
import com.iotek.service.T_Emp_TrainService;
import com.iotek.service.T_TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/8/2.
 */
@Controller
public class T_TrainController {
    @Resource
    private T_TrainService tts;
    @Resource
    private T_EmpService tes;
    @Resource
    private T_DeptService tds;
    @Resource
    private T_Emp_TrainService tets;
    @RequestMapping("/m_train")
    public String m_train(){
        return "manager/m_trains";
    }
    @RequestMapping("/getT_Train")
    public String getT_Train(int currentPage, HttpServletRequest request)throws Exception{
        return "###";
    }
    @RequestMapping("/saveTrain")
    public  String saveTrain(HttpServletRequest request)throws Exception{
        List<T_Dept> tDepts=tds.getTdeptAll();
        request.setAttribute("tDepts",tDepts);
        return "manager/m_saveTrain";
    }
    @RequestMapping("/save2_Train")
    public String save2_Train(T_Train t_train,HttpServletRequest request)throws Exception{
        //显示要判断，看t_train.tra_obj的值，若是选择的是试用期，就需要判断有没有人
        //如果是 选这部门培训，需要判断这个部门是不是有人。
        if (t_train.getTra_obj()==0){
            T_Emp tEmp=new T_Emp();
            tEmp.setE_state(0);
            List<T_Emp> t_emps=tes.getEmpByState0(tEmp);//查找员工表中state=0的人
            if (t_emps.size()!=0){
                //先是培训表的添加，需要让它返回主键
               int a=tts.saveTrain(t_train);
                System.out.println(t_train.getTra_id());
                //中间表添加
                T_Emp_Train tet=new T_Emp_Train();
                for (int i = 0; i <t_emps.size() ; i++) {
                    tet.setE_id(t_emps.get(i).getE_id());
                    tet.setTra_id(t_train.getTra_id());
                    boolean falg1=tets.saveT_Emp_Train(tet);
                }
                request.setAttribute("yes","培训添加成功，还未发布！");
                return saveTrain(request);//返回添加页面

            }else{
                request.setAttribute("nopeople","没有试用期员工，无法培训");
                return saveTrain(request);//返回添加页面
            }
        }else{
            //除了返回试用期的，就是部门id；
            int d_id=t_train.getTra_obj();
            //通过部门id查找部门所有员工
            T_Emp tEmp=new T_Emp();
            tEmp.setD_id(d_id);
            List<T_Emp> t_emps=tes.getT_EmpByd_id(tEmp);
            if (t_emps.size()!=0){
                //先是让其返回主键id
                int a=tts.saveTrain(t_train);
                System.out.println(t_train.getTra_id());//主键id
                //中间表添加
                T_Emp_Train tet=new T_Emp_Train();
                for (int i = 0; i <t_emps.size() ; i++) {
                    tet.setE_id(t_emps.get(i).getE_id());
                    tet.setTra_id(t_train.getTra_id());
                    boolean falg1=tets.saveT_Emp_Train(tet);
                }
                request.setAttribute("yes1","培训添加成功，还未发布！");
                return saveTrain(request);//返回添加 页面


            }else{
                request.setAttribute("nopeople2","该部门没有员工，无法培训");
                return saveTrain(request);//返回添加页面
            }
        }
    }
}
