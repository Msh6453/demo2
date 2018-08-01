package com.iotek.dao;

import com.iotek.model.T_Feedback;
import com.iotek.model.T_Recruit;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/29.
 */
public interface T_FeedbackMapper {
    //先判断这份简历之前是否投递
    T_Feedback getFeedbackByR_id(T_Feedback t_feedback);
    //增加
    boolean saveFeedback(T_Feedback t_feedback);
    //查看自己有没有获得面试邀请
    List<T_Feedback> getFeedbackState1(T_Feedback t_feedback);
    //分页显示面试邀请
    List<T_Feedback> getFeedbacks(Map<String,Object> data);
    //改变state的状态，判断是否接受面试邀请
    boolean updateFeedBackState(T_Feedback t_feedback);
    //管理员查看已经投递所有简历
    List<T_Feedback> getFeedBacksAll();
    //分页显示已经投递的所有简历
    List<T_Feedback> getFeedbacksByState0(Map<String,Object> data);
    //改变状态将未读状态改为已读的状态
    boolean updateFeedBackRead(T_Feedback t_feedback);
    //通过f_id查找t_feedback的对象
    T_Feedback getTF(T_Feedback t_feedback);
    //改变state=5，将生成面试时间
    boolean updateFeedBackStateAndTime(T_Feedback t_feedback);
    //查看接受面试邀请的state=4
    List<T_Feedback> getFeedBacksState4(T_Feedback t_feedback);
    //分页显示接受面试邀请的state=4
    List<T_Feedback> getFeedbacksByState4(Map<String,Object> data);
}
