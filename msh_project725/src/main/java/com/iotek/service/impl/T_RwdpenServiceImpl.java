package com.iotek.service.impl;

import com.iotek.dao.T_RwdpenMapper;
import com.iotek.model.T_Rwdpen;
import com.iotek.service.T_RwdpenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/4.
 */
@Service
public class T_RwdpenServiceImpl implements T_RwdpenService {
    @Resource
    private T_RwdpenMapper trm;

    @Override
    public boolean saveRwdpen(T_Rwdpen t_rwdpen) {
        return trm.saveRwdpen(t_rwdpen);
    }

    @Override
    public boolean deleteRwdpen(T_Rwdpen t_rwdpen) {
        return trm.deleteRwdpen(t_rwdpen);
    }

    @Override
    public List<T_Rwdpen> getT_RwdpenState1(T_Rwdpen t_rwdpen) {
        return trm.getT_RwdpenState1(t_rwdpen);
    }

    @Override
    public List<T_Rwdpen> getT_RwdpenByEidAndMoth(T_Rwdpen t_rwdpen) {
        return trm.getT_RwdpenByEidAndMoth(t_rwdpen);
    }

    @Override
    public List<T_Rwdpen> getT_RwdpenByEidAndMothCurr(Map<String,Object> data) {
        return trm.getT_RwdpenByEidAndMothCurr(data);
    }

    @Override
    public List<T_Rwdpen> getT_RwdpenByAll() {
        return trm.getT_RwdpenByAll();
    }

    @Override
    public List<T_Rwdpen> getT_RwdpenByAllCurr(Map<String, Object> data) {
        return trm.getT_RwdpenByAllCurr(data);
    }
}
