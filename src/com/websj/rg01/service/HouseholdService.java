package com.websj.rg01.service;

import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface HouseholdService {


    public List<Household> findall();//查询所有住户信息

    public void addHouseHoldUser(Household household);//保存Household

    public void deleteHouseholdUser(int id);//根据id删除住户

    public void updateHouseholdUser(Household household);//修改住户信息

    public Household findHouseholdUser(String idcard);//根据身份证查找住户信息

    PageBean<Household> findhouseholdByPage(String currentPage, String rows, Map<String,String[]> condition);

}
