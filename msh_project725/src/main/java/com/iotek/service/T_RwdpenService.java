package com.iotek.service;

import com.iotek.model.T_Rwdpen;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/4.
 */
public interface T_RwdpenService {
    //打卡迟到或者旷工，产生奖惩的记录
    boolean saveRwdpen(T_Rwdpen t_rwdpen);
    //根据员工id，日期（time），原因（reason）删除奖惩
    boolean deleteRwdpen(T_Rwdpen t_rwdpen);
    //查找员工的上一个月的奖励情况
    //查找员工的上一个月的惩罚情况
    List<T_Rwdpen> getT_RwdpenState1(T_Rwdpen t_rwdpen);
    //查找员工当月奖惩(e_id,rp_moth)
    List<T_Rwdpen> getT_RwdpenByEidAndMoth(T_Rwdpen t_rwdpen);
    //分页显示员工当月奖惩
    List<T_Rwdpen> getT_RwdpenByEidAndMothCurr(Map<String,Object> data);

    //管理员查看所有人奖惩
    List<T_Rwdpen> getT_RwdpenByAll();
    //分页显示所有人奖惩
    List<T_Rwdpen> getT_RwdpenByAllCurr(Map<String,Object> data);
}
