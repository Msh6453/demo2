package com.iotek.service;

import com.iotek.model.T_Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */
public interface T_RecruitService {
    //查看已发布的招聘信息
    List<T_Recruit> getRecruits(T_Recruit t_recruit);
}
