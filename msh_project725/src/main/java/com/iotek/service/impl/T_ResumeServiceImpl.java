package com.iotek.service.impl;

import com.iotek.dao.T_ResumeMapper;
import com.iotek.model.T_Resume;
import com.iotek.service.T_RecruitService;
import com.iotek.service.T_ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/26.
 */
@Service
public class T_ResumeServiceImpl implements T_ResumeService {
    @Resource
    private T_ResumeMapper trm;

    @Override
    public boolean saveResume(T_Resume t_resume) {
        return trm.saveResume(t_resume);
    }

    @Override
    public List<T_Resume> getresume(T_Resume t_resume) {
        return trm.getresume(t_resume);
    }

    @Override
    public List<T_Resume> get(Map<String, Object> data) {
        return trm.get(data);
    }

    @Override
    public T_Resume getRe(T_Resume t_resume) {
        return trm.getRe(t_resume);
    }

    @Override
    public boolean updateResume(T_Resume t_resume) {
        return trm.updateResume(t_resume);
    }

    @Override
    public boolean deleteResume(T_Resume t_resume) {
        return trm.deleteResume(t_resume);
    }

}
