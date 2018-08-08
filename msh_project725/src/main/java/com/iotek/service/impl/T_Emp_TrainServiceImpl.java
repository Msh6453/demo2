package com.iotek.service.impl;

import com.iotek.dao.T_Emp_TrainMapper;
import com.iotek.model.T_Emp_Train;
import com.iotek.service.T_Emp_TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/2.
 */
@Service
public class T_Emp_TrainServiceImpl implements T_Emp_TrainService {
    @Resource
    private T_Emp_TrainMapper tem;

    @Override
    public boolean saveT_Emp_Train(T_Emp_Train t_emp_train) {
        return tem.saveT_Emp_Train(t_emp_train);
    }

    @Override
    public List<T_Emp_Train> getEmpAndTrainByEid(T_Emp_Train t_emp_train) {
        return tem.getEmpAndTrainByEid(t_emp_train);
    }

    @Override
    public List<T_Emp_Train> getEmpAndTrainByEidCurr(Map<String, Object> data) {
        return tem.getEmpAndTrainByEidCurr(data);
    }
}
