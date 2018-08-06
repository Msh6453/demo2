package com.iotek.dao;

import com.iotek.model.T_Rwdpen;

/**
 * Created by Administrator on 2018/8/4.
 */
public interface T_RwdpenMapper {
    //打卡迟到或者旷工，产生奖惩的记录
    boolean saveRwdpen(T_Rwdpen t_rwdpen);
    //根据员工id，日期（time），原因（reason）删除奖惩
    boolean deleteRwdpen(T_Rwdpen t_rwdpen);
}
