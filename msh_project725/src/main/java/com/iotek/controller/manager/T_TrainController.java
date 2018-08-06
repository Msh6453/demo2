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
import utils.DoPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Track;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //查看所有培训
        List<T_Train> tTrains=tts.getT_Trains();
        if (tTrains.size()!=0) {
            int totalRows = tTrains.size();
            int totalPages = DoPage.getTotalPages(totalRows);//总页数
            final int PAGESIZE = 5;

            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
            data.put("pageSize", (currentPage) * PAGESIZE);
            List<T_Train> tTrainss = tts.getT_TrainsCurrentPage(data);

            request.setAttribute("totalPages",totalPages);
            request.setAttribute("tds",tds);
            request.setAttribute("trains",tTrainss);
            return "manager/m_get_trains";

        }else {
            request.setAttribute("notrains","没有培训记录!!");
            return "manager/m_trains";
        }
    }
    //查看未发布和已发布的培训
    @RequestMapping("/getTrainByState")
    public String getTrainByState(int state,int currentPage,HttpServletRequest request )throws Exception{
        if (state==0){
            T_Train  tt=new T_Train();
            tt.setTra_state(state);
            List<T_Train> tTrains=tts.getT_TrainsByState(tt);
            if (tTrains.size()!=0) {
                int totalRows = tTrains.size();
                int totalPages = DoPage.getTotalPages(totalRows);//总页数
                final int PAGESIZE = 5;

                Map<String, Object> data = new HashMap<>();
                data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
                data.put("pageSize", (currentPage) * PAGESIZE);
                data.put("state", state);
                List<T_Train> tTrainss = tts.getT_TrainsByStateCurrentPage(data);
                request.setAttribute("totalPages",totalPages);
                request.setAttribute("tds",tds);
                request.setAttribute("trains",tTrainss);
                return "manager/m_getTrainByState0";
            }else{
                request.setAttribute("nostate0","没有未发布培训信息");
                return getT_Train( currentPage, request);
            }
        }else{
            T_Train  tt=new T_Train();
            tt.setTra_state(state);
            List<T_Train> tTrains=tts.getT_TrainsByState(tt);
            if (tTrains.size()!=0) {
                int totalRows = tTrains.size();
                int totalPages = DoPage.getTotalPages(totalRows);//总页数
                final int PAGESIZE = 5;

                Map<String, Object> data = new HashMap<>();
                data.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
                data.put("pageSize", (currentPage) * PAGESIZE);
                data.put("state", state);
                List<T_Train> tTrainss = tts.getT_TrainsByStateCurrentPage(data);
                request.setAttribute("totalPages",totalPages);
                request.setAttribute("tds",tds);
                request.setAttribute("trains",tTrainss);
                return "manager/m_getTrainByState1";
            }else {
                request.setAttribute("nostate1", "没有已发布培训信息");
                return getT_Train(currentPage, request);
            }
        }
    }
    //发布或者撤销
    @RequestMapping("/updateTrainState")
    public String updateTrainState(int state,int id,HttpServletRequest request)throws Exception{
        if (state==0){//表示未发布，将未发布改为已发布，并且生成时间
            T_Train tTrain =new T_Train();
            tTrain.setTra_state(1);
            tTrain.setTra_id(id);
            //生成发布时间
            Date day=new Date();//获取当前时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String  releasetime=df.format(day);
            tTrain.setTra_releasetime(releasetime);
            boolean falg=tts.updateTrainsState(tTrain);//生成发布时间，改变状态
            int currentPage=1;
            return getTrainByState(state, currentPage, request );
        }else{
            T_Train tTrain =new T_Train();
            tTrain.setTra_state(0);
            tTrain.setTra_id(id);
            //生成发布时间
            Date day=new Date();//获取当前时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //时间超过一分钟不能撤销
            long a=day.getTime();//变成毫秒
            //查找发布时间
            T_Train T_time=tts.getT_Train(tTrain);
            String timee=T_time.getTra_releasetime();
            long c=df.parse(timee).getTime();//让发布时间换算成毫秒
            long b=1*60*1000;//一分钟的毫秒数
            if (c+b>a){//不能撤销了
                request.setAttribute("cba","超过修改时间，不能修改");
                int currentPage=1;
                return getTrainByState(state, currentPage, request);
            }else{
                tTrain.setTra_releasetime("0");
                boolean falg2=tts.updateTrainsState(tTrain);
                int currentPage=1;
                return getTrainByState(state, currentPage, request);
            }
        }
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
                request.setAttribute("yes1","培训添加成功，还未发布！");
                return saveTrain(request);//返回添加页面

            }else{
                request.setAttribute("nopeople1","没有试用期员工，无法培训");
                return saveTrain(request);//返回添加页面
            }
        }else{
            //除了返回试用期的，就是部门id；
            int d_id=t_train.getTra_obj();
            //通过部门id查找部门所有员工
            T_Emp tEmp=new T_Emp();
            tEmp.setD_id(d_id);
            tEmp.setE_state(3);//选择的在职的员工，state不等于3；
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
                request.setAttribute("yes2","培训添加成功，还未发布！");
                return saveTrain(request);//返回添加 页面
            }else{
                request.setAttribute("nopeople2","该部门没有员工，无法培训");
                return saveTrain(request);//返回添加页面
            }
        }
    }
}
