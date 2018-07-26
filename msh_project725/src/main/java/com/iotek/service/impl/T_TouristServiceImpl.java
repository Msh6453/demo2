package com.iotek.service.impl;

import com.iotek.dao.T_TouristMappper;
import com.iotek.model.T_Tourist;
import com.iotek.service.T_TouristService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/25.
 */
@Service
public class T_TouristServiceImpl implements T_TouristService {
    @Resource
    private T_TouristMappper tm;

    @Override
    public T_Tourist getLogin(T_Tourist t_tourist) {
        return tm.getLogin(t_tourist);
    }

    @Override
    public T_Tourist getTouristById(T_Tourist t_tourist) {
        return tm.getTouristById(t_tourist);
    }

    @Override
    public boolean register(T_Tourist t_tourist) {
        return tm.register(t_tourist);
    }
}
