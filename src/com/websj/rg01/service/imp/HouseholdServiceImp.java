package com.websj.rg01.service.imp;

import com.websj.rg01.dao.HouseholdDao;
import com.websj.rg01.dao.imp.HouseholdDaoimp;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.HouseholdService;

import java.util.List;
import java.util.Map;

public class HouseholdServiceImp implements HouseholdService {
    private HouseholdDao dao = new HouseholdDaoimp();

    @Override
    public List<Household> findall() {

        return dao.findall();
    }

    @Override
    public void addHouseHoldUser(Household household) {dao.addHousehold(household);}

    @Override
    public void deleteHouseholdUser(int id) {
        dao.deleteHousehold(id);
    }

    @Override
    public void updateHouseholdUser(Household household) {
            dao.update(household);
    }

    @Override
    public Household findHouseholdUser(String idcard) {
        return dao.findHousehold(idcard);
    }

    @Override
    public PageBean<Household> findhouseholdByPage(String _currentPage, String _rows, Map<String, String[]> condition) { //分页
        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Household> householdPageBean = new PageBean<>();

        householdPageBean.setCurrentPage(currrentPage);
        householdPageBean.setRows(rows);

        //调用查询总记录数的方法
        int householdTotalCount = dao.findHouseholdTotalCount(condition);
        householdPageBean.setTotalCount(householdTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Household> list = dao.findByPage(start,rows,condition);

        householdPageBean.setList(list);

        //计算总页数
        int pagesum = (householdTotalCount % rows) == 0 ? householdTotalCount/rows : (householdTotalCount/rows) + 1;
        householdPageBean.setTotalPage(pagesum);

        return householdPageBean;
    }
}
