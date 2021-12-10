package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.RoomDao;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.vo.RoomVo;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoomDaoImp implements RoomDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addRoom(Room room) {
        String sql = "insert into room value(null,?,?,?,null,null,null,null)";
        jdbcTemplate.update(sql,room.getPid(),room.getBid(),room.getCheckin());
    }

    @Override
    public void deleteRoom(int id) {
        String sql = "delete from room where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateRoom(Room room) {
        String sql = "update room set pid = ?,bid = ?,checkin = ?";
        jdbcTemplate.update(sql,room.getPid(),room.getBid(),room.getCheckin());
    }

    @Override
    public List<Room> findAllRoomList() {
        String sql = "select * from room";
        List<Room> roomList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Room>(Room.class));
        return roomList;
    }

    @Override
    public List<RoomVo> findAllRoom() {
        String sql = "SELECT r.id,h.`name` AS Hname,h.`idcard`,b.`name` AS Bname,b.`layers`,r.`checkin` FROM room r, building b,household h WHERE r.pid = h.`id` AND r.bid = b.`id`";
        List<RoomVo> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RoomVo>(RoomVo.class));
        return list;
    }

    @Override
    public int findRoomTotalCount(Map<String, String[]> RoomCondition) {
        //定义模板初始化sql；
        String sql = "select count(*) from room where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = RoomCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = RoomCondition.get(s)[0];//获取value
            //判断value是否存在
            if (value != null && !"".equals(value)){
                //表示存在
                stringBuilder.append("and" + s + "like ?");
                object.add("%" + value + "%");  //?条件中的值
            }
        }

        return jdbcTemplate.queryForObject(stringBuilder.toString(),Integer.class,object.toArray());
    }

    @Override
    public List<Room> findRoomByPage(int start, int rows, Map<String, String[]> RoomCondition) {
        String sql = "select * from room where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = RoomCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = RoomCondition.get(s)[0];//获取value
            //判断value是否存在
            if (value != null && !"".equals(value)){
                //表示存在
                stringBuilder.append(" and" + s + " like ? ");
                object.add("%" + value + "%");  //?条件中的值
            }
        }

        //添加分页查询
        stringBuilder.append("limit ?,?");
        object.add(start);
        object.add(rows);
        sql = stringBuilder.toString();

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Room>(Room.class),object.toArray());
    }
}

