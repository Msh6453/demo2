package com.iotek.dao;

import com.iotek.model.T_Recruit;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface T_RecruitMapper {
    //查看已发布的招聘信息
    List<T_Recruit> getRecruits(T_Recruit t_recruit);
    //分页显示招聘信息
    List<T_Recruit> get(Map<String,Object> data);
    //通过r_id查找招聘信息
    T_Recruit getByR_id(T_Recruit t_recruit);

    //管理员查看
    //管理员查看全部的招聘信息
    List<T_Recruit> getm_Recruits();
    //分页显示所有的招聘信息
    List<T_Recruit> getM(Map<String,Object> data);
    //修改state的状态
    boolean updateRecruitsState(T_Recruit t_recruit);
    //修改state=2，生成发布时间
    boolean updateRecruitsStateAndBtime(T_Recruit t_recruit);
    //修改
    boolean updateRecruits(T_Recruit t_recruit);
    //删除
    boolean deleteRecruits(T_Recruit t_recruit);
    //增加招聘信息
    boolean saveRecruits(T_Recruit t_recruit);
}
