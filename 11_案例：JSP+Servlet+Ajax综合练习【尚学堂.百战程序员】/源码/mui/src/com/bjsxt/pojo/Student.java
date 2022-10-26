package com.bjsxt.pojo;

import java.util.Date;

public class Student {
    private Integer sid;
    private String sname;
    private String sex;
    private String hobby;
    private Date birthdate;
    private String phone;
    private String reamrk;
    private Integer cid; //班级编号
    private Clazz clazz;

    public Student() {
    }

    public Student(Integer sid, String sname, String sex, String hobby, Date birthdate, String phone, String reamrk, Integer cid, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.hobby = hobby;
        this.birthdate = birthdate;
        this.phone = phone;
        this.reamrk = reamrk;
        this.cid = cid;
        this.clazz = clazz;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReamrk() {
        return reamrk;
    }

    public void setReamrk(String reamrk) {
        this.reamrk = reamrk;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthdate=" + birthdate +
                ", phone='" + phone + '\'' +
                ", reamrk='" + reamrk + '\'' +
                ", cid=" + cid +
                ", clazz=" + clazz +
                '}';
    }
}
