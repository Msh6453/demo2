package com.iotek.dao;

import com.iotek.model.T_Appeal;
import com.iotek.model.T_Attence;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/4.
 */
public interface T_AttenceMapper {
    //打上班卡，添加考勤
    boolean saveAttence(T_Attence t_attence);
    //根据日期和员工id查找考勤记录
    T_Attence getAttenceByTodayAndE_id(T_Attence t_attence);
    //打下班卡，修改eng_time
    boolean updateAttenceEndtime(T_Attence t_attence);
    //打下班卡，有可能会修改 state
    boolean updateAttenceState(T_Attence t_attence);
    //根据a_id改变，statex的状态，在打下班卡的时候修改状态
    boolean updateAttenceStatex(T_Attence t_attence);
    //根据e_id，statex，moth查找这个月中只打上班卡，不打下班卡的
    List<T_Attence> getT_AttenceByStatex(T_Attence t_attence);
    //员工查看个人的考勤记录
    List<T_Attence> getAllAttenceByEid(T_Attence t_attence);
    //分页查看所有的考勤
    List<T_Attence> getAllAttenceByEidCuu(Map<String,Object> data);

    //查看所有的考勤记录
    List<T_Attence> getAllAttence();
    //分页查看所有的考勤
    List<T_Attence> get_AllAttenceCuu(Map<String,Object> data);
}
