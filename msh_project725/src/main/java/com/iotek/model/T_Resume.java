package com.iotek.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/25.
 */
public class T_Resume implements Serializable {
    private int re_id;
    private String re_name;
    private int re_age;
    private String re_sex;
    private String re_birday;
    private String re_major;
    private String re_edu;
    private String re_endtime;
    private String re_hobby;
    private String re_tel;
    private String re_address;
    private String re_experience;
    private String re_skill;
    private int t_id;

    public T_Resume() {
    }

    public T_Resume(String re_name, int re_age, String re_sex, String re_birday, String re_major, String re_edu, String re_endtime, String re_hobby, String re_tel, String re_address, String re_experience, String re_skill, int t_id) {
        this.re_name = re_name;
        this.re_age = re_age;
        this.re_sex = re_sex;
        this.re_birday = re_birday;
        this.re_major = re_major;
        this.re_edu = re_edu;
        this.re_endtime = re_endtime;
        this.re_hobby = re_hobby;
        this.re_tel = re_tel;
        this.re_address = re_address;
        this.re_experience = re_experience;
        this.re_skill = re_skill;
        this.t_id = t_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public int getRe_age() {
        return re_age;
    }

    public void setRe_age(int re_age) {
        this.re_age = re_age;
    }

    public String getRe_sex() {
        return re_sex;
    }

    public void setRe_sex(String re_sex) {
        this.re_sex = re_sex;
    }

    public String getRe_birday() {
        return re_birday;
    }

    public void setRe_birday(String re_birday) {
        this.re_birday = re_birday;
    }

    public String getRe_major() {
        return re_major;
    }

    public void setRe_major(String re_major) {
        this.re_major = re_major;
    }

    public String getRe_edu() {
        return re_edu;
    }

    public void setRe_edu(String re_edu) {
        this.re_edu = re_edu;
    }

    public String getRe_endtime() {
        return re_endtime;
    }

    public void setRe_endtime(String re_endtime) {
        this.re_endtime = re_endtime;
    }

    public String getRe_hobby() {
        return re_hobby;
    }

    public void setRe_hobby(String re_hobby) {
        this.re_hobby = re_hobby;
    }

    public String getRe_tel() {
        return re_tel;
    }

    public void setRe_tel(String re_tel) {
        this.re_tel = re_tel;
    }

    public String getRe_address() {
        return re_address;
    }

    public void setRe_address(String re_address) {
        this.re_address = re_address;
    }

    public String getRe_experience() {
        return re_experience;
    }

    public void setRe_experience(String re_experience) {
        this.re_experience = re_experience;
    }

    public String getRe_skill() {
        return re_skill;
    }

    public void setRe_skill(String re_skill) {
        this.re_skill = re_skill;
    }

    @Override
    public String toString() {
        return "T_Resume{" +
                "re_id=" + re_id +
                ", re_name='" + re_name + '\'' +
                ", re_age=" + re_age +
                ", re_sex='" + re_sex + '\'' +
                ", re_birday='" + re_birday + '\'' +
                ", re_major='" + re_major + '\'' +
                ", re_edu='" + re_edu + '\'' +
                ", re_endtime='" + re_endtime + '\'' +
                ", re_hobby='" + re_hobby + '\'' +
                ", re_tel=" + re_tel +
                ", re_address='" + re_address + '\'' +
                ", re_experience='" + re_experience + '\'' +
                ", re_skill='" + re_skill + '\'' +
                '}';
    }
}
