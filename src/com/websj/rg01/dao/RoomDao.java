package com.websj.rg01.dao;

import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.vo.RoomVo;

import java.util.List;
import java.util.Map;

public interface RoomDao {
    //添加
    public void addRoom(Room room);
    //删除
    public void deleteRoom(int id);
    //更改
    public void updateRoom(Room room);
    //查
    public List<Room> findAllRoomList();

    public List<RoomVo> findAllRoom();

    public int findRoomTotalCount(Map<String,String[]> RoomCondition);

    public List<Room> findRoomByPage(int start, int rows, Map<String,String[]> RoomCondition);
}
