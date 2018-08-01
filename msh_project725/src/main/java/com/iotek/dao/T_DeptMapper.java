package com.iotek.dao;

import com.iotek.model.T_Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface T_DeptMapper {
    //查看所有部门
    List<T_Dept> getTdeptAll();
    //根据id查找部门
    T_Dept getT_DeptByid(T_Dept t_dept);
    //分页查看
    List<T_Dept> getT_deptsAll(Map<String,Object> data);
    //删除部门
    boolean deleteT_Dept(T_Dept t_dept);
    //修改部门
    boolean updateT_Dept(T_Dept t_dept);
    //增加部门
    //需要判断是否重名
    T_Dept getT_Dept(T_Dept t_dept);
    boolean saveT_Dept(T_Dept t_dept);

}
