package com.websj.rg01.dao;

import com.websj.rg01.entity.Staff;
import com.websj.rg01.entity.Work;

import java.util.List;
import java.util.Map;

public interface WorkDao {
    //增
    public void addWork(Work work);
    //删
    public void deleteWork(int id);
    //改
    public void updateWork(Work work);
    //查
    public List<Work> findAllWork();
    //
    public int findWorkTotalCount(Map<String,String[]> workCondition);

    public List<Work> findWorkByPage(int start, int rows, Map<String,String[]> workCondition);
}
