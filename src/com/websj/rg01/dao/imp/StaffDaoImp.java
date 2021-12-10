package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.StaffDao;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StaffDaoImp implements StaffDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addStaff(Staff staff) {
        String sql = "insert into staff value(null,?,?,?,?,?,null,null,null,null)";
        jdbcTemplate.update(sql,staff.getDid(),staff.getPosition(),staff.getPhone(),staff.getIdcard(),staff.getSalary());
    }

    @Override
    public void deleteStaff(int id) {
        String sql = "delete from staff where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateStaff(Staff staff) {
        String sql = "update staff set did = ?,position = ?,phone = ?,idcard = ?,salary = ?";
        jdbcTemplate.update(sql,staff.getDid(),staff.getPosition(),staff.getPhone(),staff.getIdcard(),staff.getSalary());
    }

    @Override
    public List<Staff> findAllStaff() {
        String sql = "select * from staff";
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
        return staffList;
    }

    @Override
    public int findStaffTotalCount(Map<String, String[]> staffCondition) {
        //定义模板初始化sql；
        String sql = "select count(*) from staff where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = staffCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = staffCondition.get(s)[0];//获取value
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
    public List<Staff> findStaffByPage(int start, int rows, Map<String, String[]> staffCondition) {
        String sql = "select * from staff where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = staffCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = staffCondition.get(s)[0];//获取value
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

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Staff>(Staff.class),object.toArray());
    }
}

