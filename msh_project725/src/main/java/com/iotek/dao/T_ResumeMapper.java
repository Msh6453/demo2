package com.iotek.dao;

import com.iotek.model.T_Resume;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/26.
 */
public interface T_ResumeMapper {
    //增加简历
    boolean saveResume(T_Resume t_resume);
    //查看简历
    List<T_Resume> getresume(T_Resume t_resume);
    //分页显示简历信息
    List<T_Resume> get(Map<String,Object> data);
    //通过id查找信息
    T_Resume getRe(T_Resume t_resume);
    //修改信息
    boolean updateResume(T_Resume t_resume);
    //删除信息
    boolean deleteResume(T_Resume t_resume);

}
