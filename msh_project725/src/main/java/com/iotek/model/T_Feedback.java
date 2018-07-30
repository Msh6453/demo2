package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/29.
 */
public class T_Feedback implements Serializable {
    private int f_id;
    private int r_id;
    private int re_id;
    private int t_id;
    private String f_btime;
    private String f_interviewtime;//面试时间
    private int f_state;//0已投递，1获得面试邀请，3拒绝面试，4接受面试

    public T_Feedback(int r_id, int re_id, String f_btime, String f_interviewtime, int f_state) {
        this.r_id = r_id;
        this.re_id = re_id;
        this.f_btime = f_btime;
        this.f_interviewtime = f_interviewtime;
        this.f_state = f_state;
    }

    public T_Feedback() {
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getF_btime() {
        return f_btime;
    }

    public void setF_btime(String f_btime) {
        this.f_btime = f_btime;
    }

    public String getF_interviewtime() {
        return f_interviewtime;
    }

    public void setF_interviewtime(String f_interviewtime) {
        this.f_interviewtime = f_interviewtime;
    }

    public int getF_state() {
        return f_state;
    }

    public void setF_state(int f_state) {
        this.f_state = f_state;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "T_Feedback{" +
                "f_id=" + f_id +
                ", r_id=" + r_id +
                ", re_id=" + re_id +
                ", t_id=" + t_id +
                ", f_btime='" + f_btime + '\'' +
                ", f_interviewtime='" + f_interviewtime + '\'' +
                ", f_state=" + f_state +
                '}';
    }
}
