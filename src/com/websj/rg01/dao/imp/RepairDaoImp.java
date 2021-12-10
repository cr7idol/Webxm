package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.RepairDao;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepairDaoImp implements RepairDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addRepair(Repair repair) {
        String sql = "insert into repair value(null,?,?,?,?,?,null,null,null,null)";
        jdbcTemplate.update(sql,repair.getBid(),repair.getReason(),repair.getSid(),repair.getPay(),repair.getRepairtime());
    }

    @Override
    public void deleteRepair(int id) {
        String sql = "delete from repair where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateRepair(Repair repair) {
        String sql = "update repair set bid = ?,reason = ?,sid = ?,pay = ?,repairtime = ?";
        jdbcTemplate.update(sql,repair.getBid(),repair.getReason(),repair.getSid(),repair.getPay(),repair.getRepairtime());
    }

    @Override
    public List<Repair> findAllRepair() {
        String sql = "select * from repair";
        List<Repair> repairList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Repair>(Repair.class));

        return repairList;
    }

    @Override
    public int findRepairTotalCount(Map<String, String[]> repairCondition) {
        //定义模板初始化sql；
        String sql = "select count(*) from repair where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = repairCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = repairCondition.get(s)[0];//获取value
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
    public List<Repair> findRepairByPage(int start, int rows, Map<String, String[]> repairCondition) {
        String sql = "select * from repair where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = repairCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = repairCondition.get(s)[0];//获取value
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

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Repair>(Repair.class),object.toArray());
    }
}
