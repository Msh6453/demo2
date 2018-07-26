package com.iotek.controller;

import com.iotek.service.T_ResumeService;
import com.iotek.service.T_TouristService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/26.
 */
@Controller
public class T_ResumeController {
    @Resource
    private T_ResumeService ts;
}
