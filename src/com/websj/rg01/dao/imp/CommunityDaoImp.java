package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.CommunityDao;
import com.websj.rg01.entity.Community;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommunityDaoImp implements CommunityDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Community> findallCommunity() { //查询小区信息
        String sql = "select * from community";
        List<Community> communityList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Community>(Community.class));
        return communityList;
    }

    @Override
    public void addCommnuity(Community community) { //添加小区信息
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into community value(null,?,?,?,null,?,null,?)";
        jdbcTemplate.update(sql,community.getName(),community.getBuiding(),community.getPark(),df.format(new Date()),df.format(new Date()));
    }

    @Override
    public void updateCommunity(Community community) {  //更新小区信息
        String sql = "update community set name = ?,building = ?,park = ?";
        jdbcTemplate.update(sql,community.getName(),community.getBuiding(),community.getPark());
    }
}
