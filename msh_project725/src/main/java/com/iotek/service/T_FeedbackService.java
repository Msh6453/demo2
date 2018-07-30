package com.iotek.service;

import com.iotek.model.T_Feedback;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/29.
 */
public interface T_FeedbackService {
    //先判断这份简历之前是否投递
    T_Feedback getFeedbackByRe_id(T_Feedback t_feedback);
    //增加
    boolean saveFeedback(T_Feedback t_feedback);
    //查看自己有没有获得面试邀请
    List<T_Feedback> getFeedbackState1(T_Feedback t_feedback);
    //分页显示面试邀请
    List<T_Feedback> getFeedbacks(Map<String,Object> data);
    //改变state的状态，判断是否接受面试邀请
    boolean updateFeedBackState(T_Feedback t_feedback);
}
