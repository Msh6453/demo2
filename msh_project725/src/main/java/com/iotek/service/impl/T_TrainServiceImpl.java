package com.iotek.service.impl;

import com.iotek.dao.T_TrainMapper;
import com.iotek.model.T_Train;
import com.iotek.service.T_TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<T_Train> getT_Trains() {
        return ttm.getT_Trains();
    }

    @Override
    public List<T_Train> getT_TrainsCurrentPage(Map<String, Object> data) {
        return ttm.getT_TrainsCurrentPage(data);
    }

    @Override
    public List<T_Train> getT_TrainsByState(T_Train t_train) {
        return ttm.getT_TrainsByState(t_train);
    }

    @Override
    public List<T_Train> getT_TrainsByStateCurrentPage(Map<String, Object> data) {
        return ttm.getT_TrainsByStateCurrentPage(data);
    }

    @Override
    public boolean updateTrainsState(T_Train t_train) {
        return ttm.updateTrainsState(t_train);
    }

    @Override
    public T_Train getT_Train(T_Train t_train) {
        return ttm.getT_Train(t_train);
    }
}
