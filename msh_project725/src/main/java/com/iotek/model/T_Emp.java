package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/31.
 */
public class T_Emp implements Serializable {
    private int e_id;
    private String e_num;
    private String e_password;
    private String e_name;
    private int e_age;
    private String e_sex;
    private String e_btime;
    private int d_id;
    private int p_id;
    private int e_state;
    private String e_tel;
    private String e_address;

    public T_Emp() {
    }

    public T_Emp(String e_num, String e_password, String e_name, int e_age, String e_sex, String e_btime, int d_id, int p_id, int e_state, String e_tel, String e_address) {
        this.e_num = e_num;
        this.e_password = e_password;
        this.e_name = e_name;
        this.e_age = e_age;
        this.e_sex = e_sex;
        this.e_btime = e_btime;
        this.d_id = d_id;
        this.p_id = p_id;
        this.e_state = e_state;
        this.e_tel = e_tel;
        this.e_address = e_address;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_num() {
        return e_num;
    }

    public void setE_num(String e_num) {
        this.e_num = e_num;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_age() {
        return e_age;
    }

    public void setE_age(int e_age) {
        this.e_age = e_age;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public String getE_btime() {
        return e_btime;
    }

    public void setE_btime(String e_btime) {
        this.e_btime = e_btime;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getE_state() {
        return e_state;
    }

    public void setE_state(int e_state) {
        this.e_state = e_state;
    }

    public String getE_tel() {
        return e_tel;
    }

    public void setE_tel(String e_tel) {
        this.e_tel = e_tel;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    @Override
    public String toString() {
        return "T_EmpController{" +
                "e_id=" + e_id +
                ", e_num='" + e_num + '\'' +
                ", e_password='" + e_password + '\'' +
                ", e_name='" + e_name + '\'' +
                ", e_age=" + e_age +
                ", e_sex='" + e_sex + '\'' +
                ", e_btime='" + e_btime + '\'' +
                ", d_id=" + d_id +
                ", p_id=" + p_id +
                ", e_state=" + e_state +
                ", e_tel='" + e_tel + '\'' +
                ", e_address='" + e_address + '\'' +
                '}';
    }
}
