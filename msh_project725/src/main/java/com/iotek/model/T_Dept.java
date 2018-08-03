package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/31.
 */
public class T_Dept implements Serializable {
    private int d_id;
    private String d_name;
    private String d_btime;

    public T_Dept() {
    }

    public T_Dept(String d_name, String d_btime) {
        this.d_name = d_name;
        this.d_btime = d_btime;
    }

    public String getD_btime() {
        return d_btime;
    }

    public void setD_btime(String d_btime) {
        this.d_btime = d_btime;
    }

    public T_Dept(String d_name) {
        this.d_name = d_name;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    @Override
    public String toString() {
        return "T_Dept{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                ", d_btime='" + d_btime + '\'' +
                '}';
    }
}
