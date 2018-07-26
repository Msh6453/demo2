package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/25.
 */
public class T_Recruit implements Serializable {
    private int r_id;
    private String r_job;
    private double r_pay;
    private String r_address;
    private int r_tel;
    private String r_email;
    private String r_experience;
    private String r_required;
    private String r_describer;
    private int r_state;

    public T_Recruit() {
    }

    public T_Recruit(String r_job, double r_pay, String r_address, int r_tel, String r_email, String r_experience, String r_required, String r_describer, int r_state) {
        this.r_job = r_job;
        this.r_pay = r_pay;
        this.r_address = r_address;
        this.r_tel = r_tel;
        this.r_email = r_email;
        this.r_experience = r_experience;
        this.r_required = r_required;
        this.r_describer = r_describer;
        this.r_state = r_state;
    }

    public int getR_state() {
        return r_state;
    }

    public void setR_state(int r_state) {
        this.r_state = r_state;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_job() {
        return r_job;
    }

    public void setR_job(String r_job) {
        this.r_job = r_job;
    }

    public double getR_pay() {
        return r_pay;
    }

    public void setR_pay(double r_pay) {
        this.r_pay = r_pay;
    }

    public String getR_address() {
        return r_address;
    }

    public void setR_address(String r_address) {
        this.r_address = r_address;
    }

    public int getR_tel() {
        return r_tel;
    }

    public void setR_tel(int r_tel) {
        this.r_tel = r_tel;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_experience() {
        return r_experience;
    }

    public void setR_experience(String r_experience) {
        this.r_experience = r_experience;
    }

    public String getR_required() {
        return r_required;
    }

    public void setR_required(String r_required) {
        this.r_required = r_required;
    }

    public String getR_describer() {
        return r_describer;
    }

    public void setR_describer(String r_describer) {
        this.r_describer = r_describer;
    }

    @Override
    public String toString() {
        return "T_Recruit{" +
                "r_id=" + r_id +
                ", r_job='" + r_job + '\'' +
                ", r_pay=" + r_pay +
                ", r_address='" + r_address + '\'' +
                ", r_tel=" + r_tel +
                ", r_email='" + r_email + '\'' +
                ", r_experience='" + r_experience + '\'' +
                ", r_required='" + r_required + '\'' +
                ", r_describer='" + r_describer + '\'' +
                ", r_state=" + r_state +
                '}';
    }
}
