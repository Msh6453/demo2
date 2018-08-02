package com.iotek.service.impl;

import com.iotek.dao.T_PositionMapper;
import com.iotek.model.T_Position;
import com.iotek.service.T_PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class T_PositionServiceImpl implements T_PositionService {
    @Resource
    private T_PositionMapper tpm;

    @Override
    public List<T_Position> getPositions(T_Position t_position)
    {
        return tpm.getPositions(t_position);
    }

    @Override
    public List<T_Position> getT_Positions() {
        return tpm.getT_Positions();
    }

    @Override
    public List<T_Position> getT_Positionss(Map<String, Object> data) {
        return tpm.getT_Positionss(data);
    }

    @Override
    public T_Position get_PostionByid(T_Position t_position) {
        return tpm.get_PostionByid(t_position);
    }

    @Override
    public boolean updateT_Pos(T_Position t_position) {
        return tpm.updateT_Pos(t_position);
    }

    @Override
    public boolean deleteT_Pos(T_Position t_position) {
        return tpm.deleteT_Pos(t_position);
    }

    @Override
    public T_Position getT_posByName(T_Position t_position) {
        return tpm.getT_posByName(t_position);
    }

    @Override
    public boolean saveT_Pos(T_Position t_position) {
        return tpm.saveT_Pos(t_position);
    }
}
