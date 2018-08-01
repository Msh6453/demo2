package com.iotek.service.impl;

import com.iotek.dao.T_RecruitMapper;
import com.iotek.model.T_Recruit;
import com.iotek.service.T_RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/25.
 */
@Service
public class T_RecruitServiceImpl implements T_RecruitService {
    @Resource
    private T_RecruitMapper trm;

    @Override
    public List<T_Recruit> getRecruits(T_Recruit t_recruit) {
        return trm.getRecruits(t_recruit);
    }

    @Override
    public List<T_Recruit> get(Map<String, Object> data) {
        return trm.get(data);
    }

    @Override
    public T_Recruit getByR_id(T_Recruit t_recruit) {
        return trm.getByR_id(t_recruit);
    }

    @Override
    public List<T_Recruit> getm_Recruits() {
        return trm.getm_Recruits();
    }

    @Override
    public List<T_Recruit> getM(Map<String, Object> data) {
        return trm.getM(data);
    }

    @Override
    public boolean updateRecruitsState(T_Recruit t_recruit) {
        return trm.updateRecruitsState(t_recruit);
    }

    @Override
    public boolean updateRecruitsStateAndBtime(T_Recruit t_recruit) {
        return trm.updateRecruitsStateAndBtime(t_recruit);
    }

    @Override
    public boolean updateRecruits(T_Recruit t_recruit) {
        return trm.updateRecruits(t_recruit);
    }

    @Override
    public boolean deleteRecruits(T_Recruit t_recruit) {
        return trm.deleteRecruits(t_recruit);
    }

    @Override
    public boolean saveRecruits(T_Recruit t_recruit) {
        return trm.saveRecruits(t_recruit);
    }
}
