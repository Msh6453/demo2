package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/2.
 */
public class T_Train implements Serializable{
    private int tra_id;
    private String tra_theme;
    private String tra_content;
    private int tra_obj;
    private String tra_begintime;
    private String tra_endtime;
    private String tra_address;
    private int tra_state;
    private String tra_releasetime;

    public T_Train() {
    }

    public T_Train(String tra_theme, String tra_content, int tra_obj, String tra_begintime, String tra_endtime, String tra_address, int tra_state, String tra_releasetime) {
        this.tra_theme = tra_theme;
        this.tra_content = tra_content;
        this.tra_obj = tra_obj;
        this.tra_begintime = tra_begintime;
        this.tra_endtime = tra_endtime;
        this.tra_address = tra_address;
        this.tra_state = tra_state;
        this.tra_releasetime = tra_releasetime;
    }

    public int getTra_state() {
        return tra_state;
    }

    public void setTra_state(int tra_state) {
        this.tra_state = tra_state;
    }

    public int getTra_id() {
        return tra_id;
    }

    public void setTra_id(int tra_id) {
        this.tra_id = tra_id;
    }

    public String getTra_theme() {
        return tra_theme;
    }

    public void setTra_theme(String tra_theme) {
        this.tra_theme = tra_theme;
    }

    public String getTra_content() {
        return tra_content;
    }

    public void setTra_content(String tra_content) {
        this.tra_content = tra_content;
    }

    public int getTra_obj() {
        return tra_obj;
    }

    public void setTra_obj(int tra_obj) {
        this.tra_obj = tra_obj;
    }

    public String getTra_begintime() {
        return tra_begintime;
    }

    public void setTra_begintime(String tra_begintime) {
        this.tra_begintime = tra_begintime;
    }

    public String getTra_endtime() {
        return tra_endtime;
    }

    public void setTra_endtime(String tra_endtime) {
        this.tra_endtime = tra_endtime;
    }

    public String getTra_address() {
        return tra_address;
    }

    public void setTra_address(String tra_address) {
        this.tra_address = tra_address;
    }

    public String getTra_releasetime() {
        return tra_releasetime;
    }

    public void setTra_releasetime(String tra_releasetime) {
        this.tra_releasetime = tra_releasetime;
    }

    @Override
    public String toString() {
        return "T_Train{" +
                "tra_id=" + tra_id +
                ", tra_theme='" + tra_theme + '\'' +
                ", tra_content='" + tra_content + '\'' +
                ", tra_obj=" + tra_obj +
                ", tra_begintime='" + tra_begintime + '\'' +
                ", tra_endtime='" + tra_endtime + '\'' +
                ", tra_address='" + tra_address + '\'' +
                ", tra_state=" + tra_state +
                ", tra_releasetime='" + tra_releasetime + '\'' +
                '}';
    }
}
