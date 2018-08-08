package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/6.
 */
public class T_Salary implements Serializable{
    private int sa_id;//薪资表id
    private int e_id;//员工id
    private String sa_month;//日期
    private double sa_salary;//基本工资
    private int sa_state;//状态
    private double sa_rpcost;//奖惩总金额
    private double sa_sscost;//社保费用
    private double sa_bonus;//绩效奖金
    private double sa_allsalary;//总的工资；

    public T_Salary() {
    }

    public T_Salary(int e_id, String sa_month, double sa_salary, int sa_state, double sa_rpcost, double sa_sscost, double sa_bonus, double sa_allsalary) {
        this.e_id = e_id;
        this.sa_month = sa_month;
        this.sa_salary = sa_salary;
        this.sa_state = sa_state;
        this.sa_rpcost = sa_rpcost;
        this.sa_sscost = sa_sscost;
        this.sa_bonus = sa_bonus;
        this.sa_allsalary = sa_allsalary;
    }

    public int getSa_id() {
        return sa_id;
    }

    public void setSa_id(int sa_id) {
        this.sa_id = sa_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getSa_month() {
        return sa_month;
    }

    public void setSa_month(String sa_month) {
        this.sa_month = sa_month;
    }

    public double getSa_salary() {
        return sa_salary;
    }

    public void setSa_salary(double sa_salary) {
        this.sa_salary = sa_salary;
    }

    public int getSa_state() {
        return sa_state;
    }

    public void setSa_state(int sa_state) {
        this.sa_state = sa_state;
    }

    public double getSa_rpcost() {
        return sa_rpcost;
    }

    public void setSa_rpcost(double sa_rpcost) {
        this.sa_rpcost = sa_rpcost;
    }

    public double getSa_sscost() {
        return sa_sscost;
    }

    public void setSa_sscost(double sa_sscost) {
        this.sa_sscost = sa_sscost;
    }

    public double getSa_bonus() {
        return sa_bonus;
    }

    public void setSa_bonus(double sa_bonus) {
        this.sa_bonus = sa_bonus;
    }

    public double getSa_allsalary() {
        return sa_allsalary;
    }

    public void setSa_allsalary(double sa_allsalary) {
        this.sa_allsalary = sa_allsalary;
    }

    @Override
    public String toString() {
        return "T_Salary{" +
                "sa_id=" + sa_id +
                ", e_id=" + e_id +
                ", sa_month='" + sa_month + '\'' +
                ", sa_salary=" + sa_salary +
                ", sa_state=" + sa_state +
                ", sa_rpcost=" + sa_rpcost +
                ", sa_sscost=" + sa_sscost +
                ", sa_bonus=" + sa_bonus +
                ", sa_allsalary=" + sa_allsalary +
                '}';
    }
}
