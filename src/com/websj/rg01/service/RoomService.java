package com.websj.rg01.service;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.vo.RoomVo;

import java.util.List;
import java.util.Map;

public interface RoomService {
    public List<RoomVo> getAllRoom(); //多表连接

    public List<Room> findAllRoomListQuery();//单独room表

    public void addRoomList(Room room);//增

    public void deleteRoomList(int id);//删

    public void updateRoomList(Room room);//改

    PageBean<Room> findRoomByPage(String currentPage, String rows, Map<String,String[]> roomCondition);
}
