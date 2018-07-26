package com.iotek.service.impl;

import com.iotek.dao.T_ResumeMapper;
import com.iotek.service.T_RecruitService;
import com.iotek.service.T_ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/26.
 */
@Service
public class T_ResumeServiceImpl implements T_ResumeService {
    @Resource
    private T_ResumeMapper trm;
}
