package com.websj.rg01.service;

import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Park;

import java.util.List;
import java.util.Map;

public interface ParkService {
    //添加
    public void addParkUser(Park park);
    //删除
    public void deleteParkUser(int id);
    //更改
    public void updateParkUser(Park park);
    //查
    public List<Park> findAllParkUser();

    PageBean<Park> findParkByPageUser(String currentPage, String rows, Map<String,String[]> parkCondition);
}
