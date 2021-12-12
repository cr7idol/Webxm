package com.websj.rg01.service.imp;

import com.websj.rg01.dao.StaffDao;
import com.websj.rg01.dao.imp.StaffDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.service.StaffService;

import java.util.List;
import java.util.Map;

public class StaffServiceImp implements StaffService {
    private StaffDao staffDao = new StaffDaoImp();

    @Override
    public void addStaffUser(Staff staff) {
        staffDao.addStaff(staff);
    }

    @Override
    public void deleteStaffUser(int id) {
        staffDao.deleteStaff(id);
    }

    @Override
    public void updateStaffUser(Staff staff) {
        staffDao.updateStaff(staff);
    }

    @Override
    public List<Staff> findAllStaffUser() {
        return staffDao.findAllStaff();
    }

    @Override
    public PageBean<Staff> findStaffByPageUser(String _currentPage, String _rows, Map<String, String[]> staffCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Staff> staffPageBean = new PageBean<Staff>();

        staffPageBean.setCurrentPage(currrentPage);
        staffPageBean.setRows(rows);

        //调用查询总记录数的方法
        int staffTotalCount = staffDao.findStaffTotalCount(staffCondition);
        staffPageBean.setTotalCount(staffTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Staff> staffByPage = staffDao.findStaffByPage(start,rows,staffCondition);

        staffPageBean.setList(staffByPage);

        //计算总页数
        int staffSumPage = (staffTotalCount % rows) == 0 ? staffTotalCount/rows : (staffTotalCount/rows) + 1;
        staffPageBean.setTotalPage(staffSumPage);

        return staffPageBean;
    }
}
