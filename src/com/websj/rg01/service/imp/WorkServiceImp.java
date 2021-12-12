package com.websj.rg01.service.imp;

import com.websj.rg01.dao.WorkDao;
import com.websj.rg01.dao.imp.WorkDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.entity.Work;
import com.websj.rg01.service.WorkService;

import java.util.List;
import java.util.Map;

public class WorkServiceImp implements WorkService {
    private WorkDao workDao = new WorkDaoImp();

    @Override
    public void addWorkUser(Work work) {
        workDao.addWork(work);
    }

    @Override
    public void deleteWorkUser(int id) {
        workDao.deleteWork(id);
    }

    @Override
    public void updateWorkUser(Work work) {
        workDao.updateWork(work);
    }

    @Override
    public List<Work> findAllWorkUser() {
        return workDao.findAllWork();
    }

    @Override
    public PageBean<Work> findAllWorkByPage(String _currentPage, String _rows, Map<String, String[]> workCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Work> workPageBean = new PageBean<Work>();

        workPageBean.setCurrentPage(currrentPage);
        workPageBean.setRows(rows);

        //调用查询总记录数的方法
        int workTotalCount = workDao.findWorkTotalCount(workCondition);
        workPageBean.setTotalCount(workTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Work> workByPage = workDao.findWorkByPage(start,rows,workCondition);

        workPageBean.setList(workByPage);

        //计算总页数
        int staffSumPage = (workTotalCount % rows) == 0 ? workTotalCount/rows : (workTotalCount/rows) + 1;
        workPageBean.setTotalPage(staffSumPage);

        return workPageBean;
    }
}
