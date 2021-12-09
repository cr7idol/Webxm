package com.websj.rg01.dao;

import com.websj.rg01.entity.Household;

import java.util.List;
import java.util.Map;

public interface HouseholdDao {

    public void addHousehold(Household household);//添加住户信息

    public void deleteHousehold(int id);//删除住户信息

    public void update(Household household);  //更新住户信息

    public Household findHousehold(String idcard); //查询住户信息

    public List<Household> findall();  //查询所有用户信息

    public int findHouseholdTotalCount(Map<String,String[]> condition);

    public List<Household> findByPage(int start,int rows,Map<String,String[]> condition);

}
