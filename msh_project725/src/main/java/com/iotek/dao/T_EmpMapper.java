package com.iotek.dao;

import com.iotek.model.T_Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface T_EmpMapper {
    //增加员工
    boolean saveTemp(T_Emp t_emp);
    //根据部门id查找员工
    List<T_Emp> getT_EmpByd_id(T_Emp t_emp);
    //根据职位id查找员工
    List<T_Emp> getT_EmpByp_id(T_Emp t_emp);

    //查看所有员工
    List<T_Emp> getT_Emps();
    //分页查看所有员工
    List<T_Emp> getT_EmpsAll(Map<String,Object> data);

    //通过e_id查找员工信息
    T_Emp getT_Emp(T_Emp t_emp);
    //修改员工信息，只是修改基本信息
    boolean updateT_Emp(T_Emp t_emp);
    //修改state的状态
    boolean updateT_EmpState(T_Emp t_emp);

    //员工状态
    //员工登录
    T_Emp getEmpByNumAndPassword(T_Emp t_emp);

    //查找试用期的员工
    List<T_Emp> getEmpByState0(T_Emp t_emp);

}
