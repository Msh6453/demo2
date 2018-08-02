package com.iotek.service.impl;

import com.iotek.dao.T_EmpMapper;
import com.iotek.model.T_Emp;
import com.iotek.service.T_EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class T_EmpServiceImpl implements T_EmpService {
    @Resource
    private T_EmpMapper tem;

    @Override
    public boolean saveTemp(T_Emp t_emp) {
        return tem.saveTemp(t_emp);
    }

    @Override
    public List<T_Emp> getT_EmpByd_id(T_Emp t_emp) {
        return tem.getT_EmpByd_id(t_emp);
    }

    @Override
    public List<T_Emp> getT_EmpByp_id(T_Emp t_emp) {
        return tem.getT_EmpByp_id(t_emp);
    }

    @Override
    public List<T_Emp> getT_Emps() {
        return tem.getT_Emps();
    }

    @Override
    public List<T_Emp> getT_EmpsAll(Map<String, Object> data) {
        return tem.getT_EmpsAll(data);
    }

    @Override
    public T_Emp getT_Emp(T_Emp t_emp) {
        return tem.getT_Emp(t_emp);
    }

    @Override
    public boolean updateT_Emp(T_Emp t_emp) {
        return tem.updateT_Emp(t_emp);
    }

    @Override
    public boolean updateT_EmpState(T_Emp t_emp) {
        return tem.updateT_EmpState(t_emp);
    }

    @Override
    public T_Emp getEmpByNumAndPassword(T_Emp t_emp) {
        return tem.getEmpByNumAndPassword(t_emp);
    }
}
