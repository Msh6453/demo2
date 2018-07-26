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
}
