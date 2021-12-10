package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.ParkDao;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.Park;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class ParkDaoImp implements ParkDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addPark(Park park) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String sql = "insert into park value(null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,park.getHid(),park.getBid(),park.getFree(),park.getBuy(),park.getCREATE_BY(),simpleDateFormat.format(new Date()),park.getUPDATE_BY(),simpleDateFormat.format(new Date()));
    }

    @Override
    public void deletePark(int id) {
        String sql = "delete from park where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updatePark(Park park) {
        String sql = "update park set hid = ?,bid = ?,free = ?,buy = ?,CREATE_BY = ?,UPDATE_BY = ?";
        jdbcTemplate.update(sql,park.getHid(),park.getBid(),park.getFree(),park.getBuy(),park.getCREATE_BY(),park.getUPDATE_BY());
    }

    @Override
    public List<Park> findAllPark() {
        String sql = "select * from park";
        List<Park> parkList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Park>(Park.class));
        return parkList;
    }

    @Override
    public int findParkTotalCount(Map<String, String[]> parkCondition) {
        //定义模板初始化sql；
        String sql = "select count(*) from park where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = parkCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = parkCondition.get(s)[0];//获取value
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
    public List<Park> findParkByPage(int start, int rows, Map<String, String[]> parkCondition) {
        String sql = "select * from park where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = parkCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = parkCondition.get(s)[0];//获取value
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

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Park>(Park.class),object.toArray());
    }
}

