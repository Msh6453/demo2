package com.iotek.dao;

import com.iotek.model.T_Appeal;
import com.iotek.model.T_Train;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/8.
 */
public interface T_AppealMapper {
    //员工生成复议
    boolean saveAppeal(T_Appeal t_appeal);
    //员工查看复议，state=1的
    List<T_Appeal> getAppealByEidAndState1(T_Appeal t_appeal);
    //分页查看
    List<T_Appeal> getAppealByEidAndState1Curr(Map<String,Object> data);
    //管理员查看未回复的state=0的复议
    List<T_Appeal> getAppealByState0(T_Appeal t_appeal);
    //管理员分页查看
    List<T_Appeal> getAppealByState0Curr(Map<String,Object> data);
    //通过app_id查找
    T_Appeal getAppeal(T_Appeal t_appeal);
    //g管理员回复复议，修改result和state
    boolean updateAppeal(T_Appeal t_appeal);
}
