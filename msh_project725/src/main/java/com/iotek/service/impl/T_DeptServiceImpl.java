package com.iotek.service.impl;

import com.iotek.dao.T_DeptMapper;
import com.iotek.model.T_Dept;
import com.iotek.service.T_DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/31.
 */
@Service
public class T_DeptServiceImpl implements T_DeptService {
    @Resource
    private T_DeptMapper tdm;

    @Override
    public List<T_Dept> getTdeptAll() {
        return tdm.getTdeptAll();
    }

    @Override
    public T_Dept getT_DeptByid(T_Dept t_dept) {
        return tdm.getT_DeptByid(t_dept);
    }

    @Override
    public List<T_Dept> getT_deptsAll(Map<String, Object> data) {
        return tdm.getT_deptsAll(data);
    }

    @Override
    public boolean deleteT_Dept(T_Dept t_dept) {
        return tdm.deleteT_Dept(t_dept);
    }

    @Override
    public boolean updateT_Dept(T_Dept t_dept) {
        return tdm.updateT_Dept(t_dept);
    }

    @Override
    public T_Dept getT_Dept(T_Dept t_dept) {
        return tdm.getT_Dept(t_dept);
    }

    @Override
    public boolean saveT_Dept(T_Dept t_dept) {
        return tdm.saveT_Dept(t_dept);
    }
}
