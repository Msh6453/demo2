package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/8.
 */
public class T_Appeal implements Serializable {
    private int app_id;
    private String app_month;
    private String app_reason;
    private String app_result;
    private String app_time;
    private int e_id;
    private int app_state;

    public T_Appeal() {
    }

    public T_Appeal(String app_month, String app_reason, String app_result, String app_time, int e_id, int app_state) {
        this.app_month = app_month;
        this.app_reason = app_reason;
        this.app_result = app_result;
        this.app_time = app_time;
        this.e_id = e_id;
        this.app_state = app_state;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getApp_month() {
        return app_month;
    }

    public void setApp_month(String app_month) {
        this.app_month = app_month;
    }

    public String getApp_reason() {
        return app_reason;
    }

    public void setApp_reason(String app_reason) {
        this.app_reason = app_reason;
    }

    public String getApp_result() {
        return app_result;
    }

    public void setApp_result(String app_result) {
        this.app_result = app_result;
    }

    public String getApp_time() {
        return app_time;
    }

    public void setApp_time(String app_time) {
        this.app_time = app_time;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getApp_state() {
        return app_state;
    }

    public void setApp_state(int app_state) {
        this.app_state = app_state;
    }

    @Override
    public String toString() {
        return "T_Appeal{" +
                "app_id=" + app_id +
                ", app_month='" + app_month + '\'' +
                ", app_reason='" + app_reason + '\'' +
                ", app_result='" + app_result + '\'' +
                ", app_time='" + app_time + '\'' +
                ", e_id=" + e_id +
                ", app_state=" + app_state +
                '}';
    }
}
