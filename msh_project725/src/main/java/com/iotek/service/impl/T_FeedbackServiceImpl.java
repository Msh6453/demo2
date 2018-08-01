package com.iotek.service.impl;

import com.iotek.dao.T_FeedbackMapper;
import com.iotek.model.T_Feedback;
import com.iotek.service.T_FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/29.
 */
@Service
public class T_FeedbackServiceImpl implements T_FeedbackService {
    @Resource
    private T_FeedbackMapper tfm;

    @Override
    public T_Feedback getFeedbackByR_id(T_Feedback t_feedback) {
        return tfm.getFeedbackByR_id(t_feedback);
    }

    @Override
    public boolean saveFeedback(T_Feedback t_feedback) {
        return tfm.saveFeedback(t_feedback);
    }

    @Override
    public List<T_Feedback> getFeedbackState1(T_Feedback t_feedback) {
        return tfm.getFeedbackState1(t_feedback);
    }

    @Override
    public List<T_Feedback> getFeedbacks(Map<String, Object> data) {
        return tfm.getFeedbacks(data);
    }

    @Override
    public boolean updateFeedBackState(T_Feedback t_feedback) {
        return tfm.updateFeedBackState(t_feedback);
    }

    @Override
    public List<T_Feedback> getFeedBacksAll() {
        return tfm. getFeedBacksAll();
    }

    @Override
    public List<T_Feedback> getFeedbacksByState0(Map<String, Object> data) {
        return tfm.getFeedbacksByState0(data);
    }

    @Override
    public boolean updateFeedBackRead(T_Feedback t_feedback) {
        return tfm.updateFeedBackRead(t_feedback);
    }

    @Override
    public T_Feedback getTF(T_Feedback t_feedback) {
        return tfm.getTF(t_feedback);
    }

    @Override
    public boolean updateFeedBackStateAndTime(T_Feedback t_feedback) {
        return tfm.updateFeedBackStateAndTime(t_feedback);
    }

    @Override
    public List<T_Feedback> getFeedBacksState4(T_Feedback t_feedback) {
        return tfm.getFeedBacksState4(t_feedback);
    }

    @Override
    public List<T_Feedback> getFeedbacksByState4(Map<String, Object> data) {
        return tfm.getFeedbacksByState4(data);
    }
}
