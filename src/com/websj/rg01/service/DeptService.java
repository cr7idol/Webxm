package com.websj.rg01.service;

import com.websj.rg01.entity.Dept;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface DeptService {
    public List<Dept> findall();//查询所有部门信息

    public void adddeptUser(Dept dept);//保存

    public void deletedeptUser(int id);//根据id删除部门

    public void updatedeptUser(Dept dept);//修改部门信息

    PageBean<Dept> finddeptByPage(String currentPage, String rows, Map<String,String[]> deptCondition);
}
