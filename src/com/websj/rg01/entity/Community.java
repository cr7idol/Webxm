package com.websj.rg01.entity;

import java.util.Date;

public class Community {
    private int id;           //社区id
    private String name;      //社区名称
    private int building;      //楼宇数量
    private int park;         //车位数量
    private String CREATE_BY; //创建人
    private Date CREATE_TIME; //创建时间
    private String UPDATE_BY; //更新人
    private Date UPDATE_TIME; //更新时间

    public Community() {}

    public Community(int id, String name, int building, int park, String CREATE_BY, Date CREATE_TIME, String UPDATE_BY, Date UPDATE_TIME) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.park = park;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getPark() {
        return park;
    }

    public void setPark(int park) {
        this.park = park;
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
        return "community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", building=" + building +
                ", park=" + park +
                ", CREATE_BY='" + CREATE_BY + '\'' +
                ", CREATE_TIME=" + CREATE_TIME +
                ", UPDATE_BY='" + UPDATE_BY + '\'' +
                ", UPDATE_TIME=" + UPDATE_TIME +
                '}';
    }
}
