package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/2.
 */
public class T_Emp_Train implements Serializable {
    private int e_tra_id;
    private int e_id;
    private int tra_id;

    public T_Emp_Train() {
    }


    public T_Emp_Train(int e_tra_id) {
        this.e_tra_id = e_tra_id;
    }

    public T_Emp_Train(int e_id, int tra_id) {
        this.e_id = e_id;
        this.tra_id = tra_id;
    }

    public int getE_tra_id() {
        return e_tra_id;
    }

    public void setE_tra_id(int e_tra_id) {
        this.e_tra_id = e_tra_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getTra_id() {
        return tra_id;
    }

    public void setTra_id(int tra_id) {
        this.tra_id = tra_id;
    }

    @Override
    public String toString() {
        return "T_Emp_Train{" +
                "e_tra_id=" + e_tra_id +
                ", e_id=" + e_id +
                ", tra_id=" + tra_id +
                '}';
    }
}
