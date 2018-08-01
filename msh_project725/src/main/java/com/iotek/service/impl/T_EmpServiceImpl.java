package com.iotek.service.impl;

import com.iotek.dao.T_EmpMapper;
import com.iotek.model.T_Emp;
import com.iotek.service.T_EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
