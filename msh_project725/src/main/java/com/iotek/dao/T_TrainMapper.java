package com.iotek.dao;

import com.iotek.model.T_Emp;
import com.iotek.model.T_Train;

/**
 * Created by Administrator on 2018/8/2.
 */
public interface T_TrainMapper {
    //新增培训，但是未发布的
    int  saveTrain(T_Train t_train);
}
