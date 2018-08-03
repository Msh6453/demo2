package com.iotek.service;

import com.iotek.model.T_Train;

/**
 * Created by Administrator on 2018/8/2.
 */
public interface T_TrainService {
    //新增培训，但是未发布的
    int saveTrain(T_Train t_train);
}
