package com.iotek.service.impl;

import com.iotek.dao.T_TrainMapper;
import com.iotek.model.T_Train;
import com.iotek.service.T_TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/2.
 */
@Service
public class T_TrainServiceImpl implements T_TrainService{
    @Resource
    private T_TrainMapper ttm;

    @Override
    public int  saveTrain(T_Train t_train) {
        return ttm.saveTrain(t_train);
    }
}
