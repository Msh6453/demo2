package com.iotek.service.impl;

import com.iotek.dao.T_SalaryMapper;
import com.iotek.model.T_Salary;
import com.iotek.service.T_SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/6.
 */
@Service
public class T_SalaryServiceImpl implements T_SalaryService{
    @Resource
    private T_SalaryMapper tsm;

    @Override
    public T_Salary getT_SalaryByDay10(T_Salary t_salary) {
        return tsm.getT_SalaryByDay10(t_salary);
    }

    @Override
    public boolean saveT_Salary(T_Salary t_salary) {
        return tsm.saveT_Salary(t_salary);
    }

    @Override
    public T_Salary getT_SalaryByEidAndMoth(T_Salary t_salary) {
        return tsm.getT_SalaryByEidAndMoth(t_salary);
    }

    /*@Override
    public List<T_Salary> getT_SalaryByEidAndMoth(T_Salary t_salary) {
        return tsm.getT_SalaryByEidAndMoth(t_salary);
    }

    @Override
    public List<T_Salary> getT_SalaryByEidAndMothCurr(Map<String,Object> data) {
        return tsm.getT_SalaryByEidAndMothCurr(data);
    }*/
}
