package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/25.
 */
public class T_Tourist implements Serializable {
    private int t_id;
    private String t_name;
    private String t_password;

    public T_Tourist() {
    }

    public T_Tourist(String t_name, String t_password) {
        this.t_name = t_name;
        this.t_password = t_password;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    @Override
    public String toString() {
        return "T_TouristMappper{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_password='" + t_password + '\'' +
                '}';
    }
}
