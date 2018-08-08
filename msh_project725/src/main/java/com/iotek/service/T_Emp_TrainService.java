package com.iotek.service;

import com.iotek.model.T_Emp_Train;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/2.
 */
public interface T_Emp_TrainService {
    //增加信息
    boolean saveT_Emp_Train(T_Emp_Train t_emp_train);
    //个人查看培训
    List<T_Emp_Train> getEmpAndTrainByEid(T_Emp_Train t_emp_train);
    //分页查看
    List<T_Emp_Train> getEmpAndTrainByEidCurr(Map<String,Object> data);
}
