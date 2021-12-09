package com.websj.rg01.service;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    public void addBuilding(Building building);//添加楼宇信息

    public void deleteBuilding(int id);//删除楼宇信息

    public void updateBuilding(Building building);  //更新楼宇信息

    public List<Building> findallBuilding();  //查询所有楼宇信息

    public int findBuildingTotalCount(Map<String,String[]> buildingCondition);

    PageBean<Building> findBuildingByPage(String currentPage, String rows, Map<String,String[]> buildingCondition);
}
