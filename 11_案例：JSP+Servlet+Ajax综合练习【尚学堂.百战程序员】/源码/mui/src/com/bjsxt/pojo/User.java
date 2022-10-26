package com.bjsxt.pojo;

public class User {
    private Integer uid;
    private String ukey;
    private String pwd;
    private String realname;
    private Integer type;

    public User() {
    }

    public User(Integer uid, String ukey, String pwd, String realname, Integer type) {
        this.uid = uid;
        this.ukey = ukey;
        this.pwd = pwd;
        this.realname = realname;
        this.type = type;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", ukey='" + ukey + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realname='" + realname + '\'' +
                ", type=" + type +
                '}';
    }
}
