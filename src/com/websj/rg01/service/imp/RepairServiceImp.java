package com.websj.rg01.service.imp;

import com.websj.rg01.dao.RepairDao;
import com.websj.rg01.dao.RoomDao;
import com.websj.rg01.dao.imp.RepairDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.service.RepairService;

import java.util.List;
import java.util.Map;

public class RepairServiceImp implements RepairService {
    private RepairDao repairDao = new RepairDaoImp();

    @Override
    public void addRepairUser(Repair repair) {
        repairDao.addRepair(repair);
    }

    @Override
    public void deleteRepairUser(int id) {
        repairDao.deleteRepair(id);
    }

    @Override
    public void updateRepairUser(Repair repair) {
        repairDao.updateRepair(repair);
    }

    @Override
    public List<Repair> findAllRepair() {
        return repairDao.findAllRepair();
    }

    @Override
    public PageBean<Repair> findRepairByPage(String _currentPage, String _rows, Map<String, String[]> repairCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Repair> repairPageBean = new PageBean<Repair>();

        repairPageBean.setCurrentPage(currrentPage);
        repairPageBean.setRows(rows);

        //调用查询总记录数的方法
        int repairTotalCount = repairDao.findRepairTotalCount(repairCondition);
        repairPageBean.setTotalCount(repairTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Repair> repairList = repairDao.findRepairByPage(start,rows,repairCondition);

        repairPageBean.setList(repairList);

        //计算总页数
        int repairpagesum = (repairTotalCount % rows) == 0 ? repairTotalCount/rows : (repairTotalCount/rows) + 1;
        repairPageBean.setTotalPage(repairpagesum);

        return repairPageBean;
    }
}
