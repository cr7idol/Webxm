package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.HouseholdDao;
import com.websj.rg01.entity.Household;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public int findHouseholdTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql；
        String sql = "select count(*) from household where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = condition.get(s)[0];//获取value
            //判断value是否存在
            if (value != null && !"".equals(value)){
                //表示存在
                stringBuilder.append("and" + s + "like ?");
                object.add("%" + value + "%");  //?条件中的值
            }
        }

        return template.queryForObject(stringBuilder.toString(),Integer.class,object.toArray());
    }

    @Override
    public List<Household> findByPage(int start, int rows, Map<String, String[]> condition) { //分页查询
        String sql = "select * from household where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = condition.get(s)[0];//获取value
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

        return template.query(sql,new BeanPropertyRowMapper<Household>(Household.class),object.toArray());
    }

}
