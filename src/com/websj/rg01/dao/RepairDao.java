package com.websj.rg01.dao;

import com.websj.rg01.entity.Repair;
import java.util.List;
import java.util.Map;

public interface RepairDao {
    //添加
    public void addRepair(Repair repair);
    //删除
    public void deleteRepair(int id);
    //更改
    public void updateRepair(Repair repair);
    //查
    public List<Repair> findAllRepair();

    public int findRepairTotalCount(Map<String,String[]> repairCondition);

    public List<Repair> findRepairByPage(int start, int rows, Map<String,String[]> repairCondition);
}
