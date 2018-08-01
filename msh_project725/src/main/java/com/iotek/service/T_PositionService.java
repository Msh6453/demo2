package com.iotek.service;

import com.iotek.model.T_Position;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface T_PositionService {
    //通过部门的d_id查找职位
    List<T_Position> getPositions(T_Position t_position);
}
