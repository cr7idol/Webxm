package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.DeptDao;
import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Dept;
import com.websj.rg01.entity.Household;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class DeptDaoImp implements DeptDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void addDept(Dept dept) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String sql = "insert into dept value(null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,dept.getCid(),dept.getName(),dept.getAddress(),dept.getPhone(),dept.getCREATE_BY(),simpleDateFormat.format(new Date()),dept.getUPDATE_BY(),simpleDateFormat.format(new Date()));
    }

    @Override
    public void deleteDept(int id) {
        String sql = "delete from dept where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateDept(Dept dept) {
        String sql = "upadte dept set cid = ?,name = ?,address = ?,phone = ?,CREATE_BY = ?,UPDATE_BY = ? where id = ?";
        jdbcTemplate.update(sql,dept.getCid(),dept.getName(),dept.getAddress(),dept.getPhone(),dept.getCREATE_BY(),dept.getUPDATE_BY(), dept.getId());

    }

    @Override
    public List<Dept> findAllDept() {
        String sql = "select * from dept";
        List<Dept> deptList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Dept>(Dept.class));
        return deptList;
    }

    @Override
    public List<Dept> findDeptByPage(int start, int rows, Map<String, String[]> deptCondition) {

        String sql = "select * from dept where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = deptCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = deptCondition.get(s)[0];//获取value
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

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Dept>(Dept.class),object.toArray());
    }


    @Override
    public int findDeptTotalCount(Map<String, String[]> deptCondition) {
        String sql = "select count(*) from dept where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = deptCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = deptCondition.get(s)[0];//获取value
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
}
