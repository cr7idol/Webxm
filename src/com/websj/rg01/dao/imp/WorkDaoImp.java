package com.websj.rg01.dao.imp;

import com.websj.rg01.dao.WorkDao;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.entity.Work;
import com.websj.rg01.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WorkDaoImp implements WorkDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addWork(Work work) {
        String sql = "insert into work value(null,?,?,?,?,?,null,null,null,null)";
        jdbcTemplate.update(sql,work.getSid(),work.getWorktime(),work.getContent(),work.getAttendance(),work.getBuilds());
    }

    @Override
    public void deleteWork(int id) {
        String sql = "delete from work where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateWork(Work work) {
        String sql = "update work set sid = ?,worktime = ?,content = ?,attendance = ?,builds = ?";
        jdbcTemplate.update(sql,work.getSid(),work.getWorktime(),work.getContent(),work.getAttendance(),work.getBuilds());
    }

    @Override
    public List<Work> findAllWork() {
        String sql = "select * from work";
        List<Work> workList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Work>(Work.class));
        return workList;
    }

    @Override
    public int findWorkTotalCount(Map<String, String[]> workCondition) {
        //定义模板初始化sql；
        String sql = "select count(*) from work where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = workCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = workCondition.get(s)[0];//获取value
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
    public List<Work> findWorkByPage(int start, int rows, Map<String, String[]> workCondition) {
        String sql = "select * from work where 1=1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历
        Set<String> keySet = workCondition.keySet();
        //定义参数集合
        List<Object> object =new ArrayList<Object>();

        for (String s : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(s) || "rows".equals(s)){
                continue;
            }
            String value = workCondition.get(s)[0];//获取value
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

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Work>(Work.class),object.toArray());
    }
}

