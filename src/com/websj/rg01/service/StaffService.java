package com.websj.rg01.service;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffService {
    //增
    public void addStaffUser(Staff staff);
    //删
    public void deleteStaffUser(int id);
    //改
    public void updateStaffUser(Staff staff);
    //查所有
    public List<Staff> findAllStaffUser();
    //
    PageBean<Staff> findStaffByPageUser(String currentPage, String rows, Map<String,String[]> staffCondition);
}
