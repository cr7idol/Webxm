package com.websj.rg01.entity;

import java.util.Date;

public class Dept {
    private int id;           //部门id
    private int cid;          //小区id
    private String name;      //部门名称
    private String address;   //部门地址
    private String phone;     //部门电话
    private String CREATE_BY; //创建人
    private Date CREATE_TIME; //创建时间
    private String UPDATE_BY; //更新人
    private Date UPDATE_TIME; //更新时间

    public Dept() {}

    public Dept(int id, int cid, String name, String address, String phone, String CREATE_BY, Date CREATE_TIME, String UPDATE_BY, Date UPDATE_TIME) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.CREATE_BY = CREATE_BY;
        this.CREATE_TIME = CREATE_TIME;
        this.UPDATE_BY = UPDATE_BY;
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCREATE_BY() {
        return CREATE_BY;
    }

    public void setCREATE_BY(String CREATE_BY) {
        this.CREATE_BY = CREATE_BY;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getUPDATE_BY() {
        return UPDATE_BY;
    }

    public void setUPDATE_BY(String UPDATE_BY) {
        this.UPDATE_BY = UPDATE_BY;
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    @Override
    public String toString() {
        return "dept{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", CREATE_BY='" + CREATE_BY + '\'' +
                ", CREATE_TIME=" + CREATE_TIME +
                ", UPDATE_BY='" + UPDATE_BY + '\'' +
                ", UPDATE_TIME=" + UPDATE_TIME +
                '}';
    }
}
