package com.websj.rg01.service.imp;

import com.websj.rg01.dao.ParkDao;
import com.websj.rg01.dao.imp.ParkDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Park;
import com.websj.rg01.service.ParkService;

import java.util.List;
import java.util.Map;

public class ParkServiceImp implements ParkService {
    private ParkDao parkDao = new ParkDaoImp();
    @Override
    public void addParkUser(Park park) {
        parkDao.addPark(park);
    }

    @Override
    public void deleteParkUser(int id) {
        parkDao.deletePark(id);
    }

    @Override
    public void updateParkUser(Park park) {
        parkDao.updatePark(park);
    }

    @Override
    public List<Park> findAllParkUser() {
        return parkDao.findAllPark();
    }

    @Override
    public PageBean<Park> findParkByPageUser(String _currentPage, String _rows, Map<String, String[]> parkCondition) {
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Park> parkPageBean = new PageBean<Park>();

        parkPageBean.setCurrentPage(currrentPage);
        parkPageBean.setRows(rows);

        //调用查询总记录数的方法
        int parkTotalCount = parkDao.findParkTotalCount(parkCondition);
        parkPageBean.setTotalCount(parkTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Park> list = parkDao.findParkByPage(start,rows,parkCondition);

        parkPageBean.setList(list);

        //计算总页数
        int pagesum = (parkTotalCount % rows) == 0 ? parkTotalCount/rows : (parkTotalCount/rows) + 1;
        parkPageBean.setTotalPage(pagesum);

        return parkPageBean;
    }
}



