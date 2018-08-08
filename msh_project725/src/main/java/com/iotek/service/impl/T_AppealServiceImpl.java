package com.iotek.service.impl;

import com.iotek.dao.T_AppealMapper;
import com.iotek.model.T_Appeal;
import com.iotek.service.T_AppealService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/8.
 */
@Service
public class T_AppealServiceImpl implements T_AppealService {
    @Resource
    private T_AppealMapper tam;

    @Override
    public boolean saveAppeal(T_Appeal t_appeal) {
        return tam.saveAppeal(t_appeal);
    }

    @Override
    public List<T_Appeal> getAppealByEidAndState1(T_Appeal t_appeal) {
        return tam.getAppealByEidAndState1(t_appeal);
    }

    @Override
    public List<T_Appeal> getAppealByEidAndState1Curr(Map<String, Object> data) {
        return tam.getAppealByEidAndState1Curr(data);
    }

    @Override
    public List<T_Appeal> getAppealByState0(T_Appeal t_appeal) {
        return tam.getAppealByState0(t_appeal);
    }

    @Override
    public List<T_Appeal> getAppealByState0Curr(Map<String, Object> data) {
        return tam.getAppealByState0Curr(data);
    }

    @Override
    public T_Appeal getAppeal(T_Appeal t_appeal) {
        return tam.getAppeal(t_appeal);
    }

    @Override
    public boolean updateAppeal(T_Appeal t_appeal) {
        return tam.updateAppeal(t_appeal);
    }
}
