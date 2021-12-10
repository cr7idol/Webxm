package com.websj.rg01.dao;

import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffDao {
    //添加
    public void addStaff(Staff staff);
    //删除
    public void deleteStaff(int id);
    //更改
    public void updateStaff(Staff staff);
    //查
    public List<Staff> findAllStaff();

    public int findStaffTotalCount(Map<String,String[]> staffCondition);

    public List<Staff> findStaffByPage(int start, int rows, Map<String,String[]> staffCondition);
}
