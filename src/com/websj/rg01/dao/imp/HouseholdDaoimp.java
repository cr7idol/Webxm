package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.HouseholdDao;
import com.websj.rg01.entity.Household;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HouseholdDaoimp implements HouseholdDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addHousehold(Household household) {  //添加
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into household value(null,?,?,?,?,?,null ,?,null ,?)";
        template.update(sql,household.getRid(),household.getName(),household.getNumber(),household.getIdcard(),household.getSex(),df.format(new Date()),df.format(new Date()));
    }

    @Override
    public void deleteHousehold(int id) {       //删除
        String sql = "delete from household where id = ?";
        template.update(sql,id);
    }

    @Override
    public void update(Household household) {       //更新
        String sql = "update household set rid = ?,name = ?,number = ?,idcard = ?,sex = ? where id = ?";
        template.update(sql,household.getRid(),household.getName(),household.getNumber(),household.getIdcard(),household.getSex(),household.getId());
    }

    @Override
    public Household findHousehold(String idcard) {     //按身份证查找
        String sql = "select * from household where idcard = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<Household>(Household.class),idcard);
    }

    @Override
    public List<Household> findall() {      //查询所有用户信息
        String sql = "select * from household";
        List<Household> Users = template.query(sql, new BeanPropertyRowMapper<Household>(Household.class));

        return Users;
    }

}
