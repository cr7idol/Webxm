package com.websj.rg01.service.imp;

import com.websj.rg01.dao.DeptDao;
import com.websj.rg01.dao.imp.DeptDaoImp;
import com.websj.rg01.entity.Dept;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.DeptService;

import java.util.List;
import java.util.Map;

public class DeptServiceImp implements DeptService {
    private DeptDao deptDao = new DeptDaoImp();
    @Override
    public List<Dept> findall() {
        return deptDao.findAllDept();
    }

    @Override
    public void adddeptUser(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void deletedeptUser(int id) {
        deptDao.deleteDept(id);
    }

    @Override
    public void updatedeptUser(Dept dept) {
        deptDao.updateDept(dept);
    }

    @Override
    public PageBean<Dept> finddeptByPage(String _currentPage, String _rows, Map<String, String[]> deptCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Dept> deptPageBean = new PageBean<Dept>();

        deptPageBean.setCurrentPage(currrentPage);
        deptPageBean.setRows(rows);

        //调用查询总记录数的方法
        int deptTotalCount = deptDao.findDeptTotalCount(deptCondition);
        deptPageBean.setTotalCount(deptTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Dept> deptList = deptDao.findDeptByPage(start,rows,deptCondition);

        deptPageBean.setList(deptList);

        //计算总页数
        int deptpagesum = (deptTotalCount % rows) == 0 ? deptTotalCount/rows : (deptTotalCount/rows) + 1;
        deptPageBean.setTotalPage(deptpagesum);

        return deptPageBean;
    }
}
