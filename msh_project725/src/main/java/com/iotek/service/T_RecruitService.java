package com.iotek.service;

import com.iotek.model.T_Recruit;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface T_RecruitService {
    //查看已发布的招聘信息
    List<T_Recruit> getRecruits(T_Recruit t_recruit);
    //分页显示招聘信息
    List<T_Recruit> get(Map<String,Object> data);
    //通过r_id查找招聘信息
    T_Recruit getByR_id(T_Recruit t_recruit);
}
