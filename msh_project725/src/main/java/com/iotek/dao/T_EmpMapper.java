package com.iotek.dao;

import com.iotek.model.T_Emp;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface T_EmpMapper {
    //增加员工
    boolean saveTemp(T_Emp t_emp);
    //根据部门id查找员工
    List<T_Emp> getT_EmpByd_id(T_Emp t_emp);
}
