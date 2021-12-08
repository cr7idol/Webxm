package com.websj.rg01.entity;

import java.util.Date;

public class Room {
    private int id;             //房间id
    private int pid;            //住户id
    private int bid;            //楼宇id
    private Date checkin;       //入住时间
    private String CREATE_BY;   //创建人
    private Date CREATE_TIME;   //创建时间
    private String UPDATE_BY;   //更新人
    private Date UPDATE_TIME;   //更新时间

    public Room() {}

    public Room(int id, int pid, int bid, Date checkin, String CREATE_BY, Date CREATE_TIME, String UPDATE_BY, Date UPDATE_TIME) {
        this.id = id;
        this.pid = pid;
        this.bid = bid;
        this.checkin = checkin;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
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
        return "room{" +
                "id=" + id +
                ", pid=" + pid +
                ", bid=" + bid +
                ", checkin=" + checkin +
                ", CREATE_BY='" + CREATE_BY + '\'' +
                ", CREATE_TIME=" + CREATE_TIME +
                ", UPDATE_BY='" + UPDATE_BY + '\'' +
                ", UPDATE_TIME=" + UPDATE_TIME +
                '}';
    }
}
