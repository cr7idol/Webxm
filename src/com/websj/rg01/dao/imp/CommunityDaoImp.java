package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.CommunityDao;
import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommunityDaoImp implements CommunityDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void deleteCommunity(int id) {
        String sql = "delete from community where id = ?";
        jdbcTemplate.update(sql,id);
    }

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
        jdbcTemplate.update(sql,community.getName(),community.getBuilding(),community.getPark(),df.format(new Date()),df.format(new Date()));
    }

    @Override
    public void updateCommunity(Community community) {  //更新小区信息
        String sql = "update community set name = ?,building = ?,park = ?";
        jdbcTemplate.update(sql,community.getName(),community.getBuilding(),community.getPark());



    }

    @Override
    public int findCommnityTotalCount(Map<String, String[]> communityCondition) {
        String sql = "select count(*) from community where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = communityCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = communityCondition.get(s)[0];//获取value
            //判断value是否存在
            if (value != null && !"".equals(value)){
                //表示存在
                stringBuilder.append("and" + s + "like ?");
                object.add("%" + value + "%");
                //?条件中的值
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(object);
        return jdbcTemplate.queryForObject(stringBuilder.toString(),Integer.class,object.toArray());
    }

    @Override
    public List<Community> findByPage(int start, int rows, Map<String, String[]> communityCondition) {
        String sql = "select * from community where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = communityCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = communityCondition.get(s)[0];//获取value
            //判断value是否存在
            if (value != null && !"".equals(value)){
                //表示存在
                stringBuilder.append("and" + s + "like ?");
                object.add("%" + value + "%");  //?条件中的值
            }
        }

        //添加分页查询
        stringBuilder.append("limit ?,?");
        object.add(start);
        object.add(rows);
        sql = stringBuilder.toString();
        System.out.println(sql);
        System.out.println(object);

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Community>(Community.class),object.toArray());
    }
}
