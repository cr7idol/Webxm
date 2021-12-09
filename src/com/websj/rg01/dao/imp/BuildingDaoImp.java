package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.BuildingDao;
import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Community;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class BuildingDaoImp implements BuildingDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        @Override
        public void addBuilding(Building building) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "insert into building value(null,?,?,?,?,null,?,null,?)";
            jdbcTemplate.update(sql,building.getCid(),building.getName(),building.getLayers(),building.getHousehold(),df.format(new Date()),df.format(new Date()));
        }

        @Override
        public void deleteBuilding(int id) {
            String sql = "delete from building where id = ?";
            jdbcTemplate.update(sql,id);
        }

        @Override
        public void updateBuilding(Building building) {
            String sql = "update building set cid = ?,name = ?,layers = ?,household = ?";
            jdbcTemplate.update(sql,building.getCid(),building.getName(),building.getLayers(),building.getHousehold());
        }

        @Override
        public List<Building> findallBuilding() {

            String sql = "select * from building";
            List<Building> buildingList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Building>(Building.class));
            return buildingList;
        }

        @Override
        public int findBuildingTotalCount(Map<String, String[]> buildingCondition) {
            String sql = "select count(*) from building where 1 = 1";
            StringBuilder stringBuilder = new StringBuilder(sql);
            //遍历
            Set<String> keySet = buildingCondition.keySet();
            //定义参数集合
            List<Object> object =new ArrayList<Object>();

            for (String s : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(s) || "rows".equals(s)){
                    continue;
                }
                String value = buildingCondition.get(s)[0];//获取value
                //判断value是否存在
                if (value != null && !"".equals(value)){
                    //表示存在
                    stringBuilder.append("and" + s + "like ?");
                    object.add("%" + value + "%");
                    //?条件中的值
                }
            }

            return jdbcTemplate.queryForObject(stringBuilder.toString(),Integer.class,object.toArray());
        }

        @Override
        public List<Building> findBuildingByPage(int start, int rows, Map<String, String[]> buildingCondition) {
            String sql = "select * from building where 1=1";
            StringBuilder stringBuilder = new StringBuilder(sql);
            //遍历
            Set<String> keySet = buildingCondition.keySet();
            //定义参数集合
            List<Object> object =new ArrayList<>();

            for (String s : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(s) || "rows".equals(s)){
                    continue;
                }
                String value = buildingCondition.get(s)[0];//获取value
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

            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Building>(Building.class),object.toArray());
        }
    }

