package com.iotek.service.impl;

import com.iotek.dao.T_PositionMapper;
import com.iotek.model.T_Position;
import com.iotek.service.T_PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class T_PositionServiceImpl implements T_PositionService {
    @Resource
    private T_PositionMapper tpm;

    @Override
    public List<T_Position> getPositions(T_Position t_position) {
        return tpm.getPositions(t_position);
    }
}
