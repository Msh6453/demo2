package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/31.
 */
public class T_Position implements Serializable {
    private int p_id;
    private String p_name;
    private int d_id;

    public T_Position() {
    }

    public T_Position(String p_name, int d_id) {
        this.p_name = p_name;
        this.d_id = d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "T_Position{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", d_id=" + d_id +
                '}';
    }
}
