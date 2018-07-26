package com.iotek.service;

import com.iotek.model.T_Tourist;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface T_TouristService {
    //登录
    T_Tourist getLogin(T_Tourist t_tourist);
    //用户名判重
    T_Tourist getTouristById(T_Tourist t_tourist);
    //注册
    boolean register(T_Tourist t_tourist);
}
