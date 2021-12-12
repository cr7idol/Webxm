package com.websj.rg01.service;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Repair;

import java.util.List;
import java.util.Map;

public interface RepairService {
    //添加
    public void addRepairUser(Repair repair);
    //删除
    public void deleteRepairUser(int id);
    //更改
    public void updateRepairUser(Repair repair);

    public List<Repair> findAllRepair();
    //查
    PageBean<Repair> findRepairByPage(String currentPage, String rows, Map<String,String[]> repairCondition);
}
