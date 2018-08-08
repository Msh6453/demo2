package com.iotek.model;

import javax.lang.model.element.NestingKind;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/4.
 */
public class T_Attence implements Serializable {
    private int a_id;
    private String a_moth;
    private String a_today;
    private String a_begintime;
    private String a_endtime;
    private int a_state;
    private int e_id;
    private int a_statex;

    public T_Attence() {
    }

    public T_Attence(String a_moth, String a_today, String a_begintime, String a_endtime, int a_state, int e_id, int a_statex) {
        this.a_moth = a_moth;
        this.a_today = a_today;
        this.a_begintime = a_begintime;
        this.a_endtime = a_endtime;
        this.a_state = a_state;
        this.e_id = e_id;
        this.a_statex = a_statex;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_today() {
        return a_today;
    }

    public void setA_today(String a_today) {
        this.a_today = a_today;
    }

    public String getA_begintime() {
        return a_begintime;
    }

    public void setA_begintime(String a_begintime) {
        this.a_begintime = a_begintime;
    }

    public String getA_endtime() {
        return a_endtime;
    }

    public void setA_endtime(String a_endtime) {
        this.a_endtime = a_endtime;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getA_moth() {
        return a_moth;
    }

    public void setA_moth(String a_moth) {
        this.a_moth = a_moth;
    }

    public int getA_statex() {
        return a_statex;
    }

    public void setA_statex(int a_statex) {
        this.a_statex = a_statex;
    }

    @Override
    public String toString() {
        return "T_Attence{" +
                "a_id=" + a_id +
                ", a_moth='" + a_moth + '\'' +
                ", a_today='" + a_today + '\'' +
                ", a_begintime='" + a_begintime + '\'' +
                ", a_endtime='" + a_endtime + '\'' +
                ", a_state=" + a_state +
                ", e_id=" + e_id +
                ", a_statex=" + a_statex +
                '}';
    }
}
