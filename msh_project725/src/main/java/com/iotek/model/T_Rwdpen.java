package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/4.
 */
public class T_Rwdpen implements Serializable{
    private int rp_id;
    private double rp_money;
    private String rp_time;
    private String rp_reason;
    private String rp_month;
    private int e_id;
    private int rp_state;

    public T_Rwdpen() {
    }

    public T_Rwdpen(double rp_money, String rp_time, String rp_reason, String rp_month, int e_id, int rp_state) {
        this.rp_money = rp_money;
        this.rp_time = rp_time;
        this.rp_reason = rp_reason;
        this.rp_month = rp_month;
        this.e_id = e_id;
        this.rp_state = rp_state;
    }

    public int getRp_id() {
        return rp_id;
    }

    public void setRp_id(int rp_id) {
        this.rp_id = rp_id;
    }

    public double getRp_money() {
        return rp_money;
    }

    public void setRp_money(double rp_money) {
        this.rp_money = rp_money;
    }

    public String getRp_time() {
        return rp_time;
    }

    public void setRp_time(String rp_time) {
        this.rp_time = rp_time;
    }

    public String getRp_reason() {
        return rp_reason;
    }

    public void setRp_reason(String rp_reason) {
        this.rp_reason = rp_reason;
    }

    public String getRp_month() {
        return rp_month;
    }

    public void setRp_month(String rp_month) {
        this.rp_month = rp_month;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getRp_state() {
        return rp_state;
    }

    public void setRp_state(int rp_state) {
        this.rp_state = rp_state;
    }

    @Override
    public String toString() {
        return "T_Rwdpen{" +
                "rp_id=" + rp_id +
                ", rp_money=" + rp_money +
                ", rp_time='" + rp_time + '\'' +
                ", rp_reason='" + rp_reason + '\'' +
                ", rp_month='" + rp_month + '\'' +
                ", e_id=" + e_id +
                ", rp_state=" + rp_state +
                '}';
    }
}
