package com.websj.rg01.dao;

import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.Park;

import java.util.List;
import java.util.Map;

public interface ParkDao {
    //添加
    public void addPark(Park park);
    //删除
    public void deletePark(int id);
    //更改
    public void updatePark(Park park);
    //查
    public List<Park> findAllPark();

    public int findParkTotalCount(Map<String,String[]> parkCondition);

    public List<Park> findParkByPage(int start, int rows, Map<String,String[]> parkCondition);
}
