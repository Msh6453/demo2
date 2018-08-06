package com.iotek.service.impl;

import com.iotek.dao.T_AttenceMapper;
import com.iotek.model.T_Attence;
import com.iotek.service.T_AttenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/4.
 */
@Service
public class T_AttenceServiceImpl implements T_AttenceService {
    @Resource
    private T_AttenceMapper tam;

    @Override
    public boolean saveAttence(T_Attence t_attence) {
        return tam.saveAttence(t_attence);
    }

    @Override
    public T_Attence getAttenceByTodayAndE_id(T_Attence t_attence) {
        return tam.getAttenceByTodayAndE_id(t_attence);
    }

    @Override
    public boolean updateAttenceEndtime(T_Attence t_attence) {
        return tam.updateAttenceEndtime(t_attence);
    }

    @Override
    public boolean updateAttenceState(T_Attence t_attence) {
        return tam.updateAttenceState(t_attence);
    }

    @Override
    public boolean updateAttenceStatex(T_Attence t_attence) {
        return tam.updateAttenceStatex(t_attence);
    }
}
