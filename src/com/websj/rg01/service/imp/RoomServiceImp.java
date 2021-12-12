package com.websj.rg01.service.imp;

import com.websj.rg01.dao.RoomDao;
import com.websj.rg01.dao.imp.RoomDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.vo.RoomVo;
import com.websj.rg01.service.RoomService;

import java.util.List;
import java.util.Map;

public class RoomServiceImp implements RoomService {
    private RoomDao roomDao = new RoomDaoImp();

    @Override
    public List<RoomVo> getAllRoom() {
        List<RoomVo> list = roomDao.findAllRoom();
        return list;
    }

    @Override
    public List<Room> findAllRoomListQuery() {
        return roomDao.findAllRoomList();
    }

    @Override
    public void addRoomList(Room room) {
        roomDao.addRoom(room);
    }

    @Override
    public void deleteRoomList(int id) {
        roomDao.deleteRoom(id);
    }

    @Override
    public void updateRoomList(Room room) {
        roomDao.updateRoom(room);
    }

    @Override
    public PageBean<Room> findRoomByPage(String _currentPage, String _rows, Map<String, String[]> roomCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Room> roomPageBean = new PageBean<Room>();

        roomPageBean.setCurrentPage(currrentPage);
        roomPageBean.setRows(rows);

        //调用查询总记录数的方法
        int roomTotalCount = roomDao.findRoomTotalCount(roomCondition);
        roomPageBean.setTotalCount(roomTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Room> roomByPage = roomDao.findRoomByPage(start,rows,roomCondition);

        roomPageBean.setList(roomByPage);

        //计算总页数
        int roompagesum = (roomTotalCount % rows) == 0 ? roomTotalCount/rows : (roomTotalCount/rows) + 1;
        roomPageBean.setTotalPage(roompagesum);

        return roomPageBean;
    }
}
