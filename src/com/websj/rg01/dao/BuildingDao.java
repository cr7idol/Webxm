package com.websj.rg01.dao;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;

import java.util.List;
import java.util.Map;

public interface BuildingDao {
    public void addBuilding(Building building);//添加楼宇信息

    public void deleteBuilding(int id);//删除楼宇信息

    public void updateBuilding(Building building);  //更新楼宇信息

    public List<Building> findallBuilding();  //查询所有楼宇信息

    public int findBuildingTotalCount(Map<String,String[]> buildingCondition);

    public List<Building> findBuildingByPage(int start,int rows,Map<String,String[]> buildingCondition);
}
