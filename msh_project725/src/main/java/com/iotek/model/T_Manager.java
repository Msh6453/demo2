package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/30.
 */
public class T_Manager implements Serializable {
    private int m_id;
    private String m_name;
    private String m_password;

    public T_Manager(String m_name, String m_password) {
        this.m_name = m_name;
        this.m_password = m_password;
    }

    public T_Manager() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    @Override
    public String toString() {
        return "T_Manager{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_password='" + m_password + '\'' +
                '}';
    }
}
