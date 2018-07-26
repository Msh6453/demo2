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
}
