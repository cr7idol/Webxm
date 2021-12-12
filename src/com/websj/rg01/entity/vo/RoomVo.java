package com.websj.rg01.entity.vo;

import java.util.Date;

public class RoomVo {

    //r.id,h.`name`,h.`idcard`,b.`name`,b.`layers`,r.`checkin`

    Integer id;
    String Hname;
    String idcard;
    String Bname;
    Integer layers;
    Date checkin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public Integer getLayers() {
        return layers;
    }

    public void setLayers(Integer layers) {
        this.layers = layers;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public RoomVo(Integer id, String hname, String idcard, String bname, Integer layers, Date checkin) {
        this.id = id;
        Hname = hname;
        this.idcard = idcard;
        Bname = bname;
        this.layers = layers;
        this.checkin = checkin;
    }

    @Override
    public String toString() {
        return "RoomVo{" +
                "id=" + id +
                ", Hname='" + Hname + '\'' +
                ", idcard='" + idcard + '\'' +
                ", Bname='" + Bname + '\'' +
                ", layers=" + layers +
                ", checkin=" + checkin +
                '}';
    }

    public RoomVo() {
    }

}
