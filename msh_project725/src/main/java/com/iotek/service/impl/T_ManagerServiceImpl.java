package com.iotek.service.impl;

import com.iotek.dao.T_ManagerMapper;
import com.iotek.model.T_Manager;
import com.iotek.service.T_ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/30.
 */
@Service
public class T_ManagerServiceImpl implements T_ManagerService {
    @Resource
    private T_ManagerMapper tmm;

    @Override
    public T_Manager getManager(T_Manager t_manager) {
        return tmm.getManager(t_manager);
    }
}
