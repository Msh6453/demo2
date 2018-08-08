package com.iotek.service;

import com.iotek.model.T_Salary;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/6.
 */
public interface T_SalaryService {
    //通过输入日期，检查这个月有没有结算工资
    T_Salary getT_SalaryByDay10(T_Salary t_salary);
    //添加生成薪资表
    boolean saveT_Salary(T_Salary t_salary);


   /* //根据员工id和月份查看薪资
    List<T_Salary> getT_SalaryByEidAndMoth(T_Salary t_salary);
    //分页查看员工id和月份查看薪资
    List<T_Salary> getT_SalaryByEidAndMothCurr(Map<String,Object> data);*/

    //根据员工id和月份查看薪资,因为每月只有一份薪资表，不需要list
    T_Salary getT_SalaryByEidAndMoth(T_Salary t_salary);

}
