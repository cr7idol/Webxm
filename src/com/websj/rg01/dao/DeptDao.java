package com.websj.rg01.dao;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Dept;
import com.websj.rg01.entity.Household;

import java.util.List;
import java.util.Map;

public interface DeptDao {
    //添加dept
    public void addDept(Dept dept);

    //删除dept
    public void deleteDept(int id);

    //修改dept
    public void updateDept(Dept dept);

    //查询dept
    public List<Dept> findAllDept();

    //分页查找部门信息
    public List<Dept> findDeptByPage(int start, int rows, Map<String,String[]> buildingCondition);

    //
    public int findDeptTotalCount(Map<String,String[]> deptCondition);
}
