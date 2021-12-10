package com.websj.rg01.service.imp;

import com.websj.rg01.dao.BuildingDao;
import com.websj.rg01.dao.RoomDao;
import com.websj.rg01.dao.imp.BuildingDaoImp;
import com.websj.rg01.dao.imp.RoomDaoImp;
import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.vo.RoomVo;
import com.websj.rg01.service.BuildingService;

import java.util.List;
import java.util.Map;

public class BuildingServiceImp implements BuildingService {

        BuildingDao buildingDao =new BuildingDaoImp();

        RoomDao roomDao = new RoomDaoImp();
        @Override
        public void addBuilding(Building building) {
            buildingDao.addBuilding(building);
        }

        @Override
        public void deleteBuilding(int id) {
            buildingDao.deleteBuilding(id);
        }

        @Override
        public void updateBuilding(Building building) {
            buildingDao.updateBuilding(building);
        }

        @Override
        public List<Building> findallBuilding() {
            return buildingDao.findallBuilding();
        }

        @Override
        public int findBuildingTotalCount(Map<String, String[]> buildingCondition) {
            return 0;
        }

        @Override
        public PageBean<Building> findBuildingByPage(String _currentPage, String _rows, Map<String, String[]> buildingCondition) {
            int currrentPage = Integer.parseInt(_currentPage);
            int rows = Integer.parseInt(_rows);

            if (currrentPage < 0){
                currrentPage = 1;
            }
            //创建空PageBean对象
            PageBean<Building> buildingPageBean = new PageBean<>();

            buildingPageBean.setCurrentPage(currrentPage);
            buildingPageBean.setRows(rows);

            //调用查询总记录数的方法
            int buildingTotalCount = buildingDao.findBuildingTotalCount(buildingCondition);
            buildingPageBean.setTotalCount(buildingTotalCount);

            //调用方法查询List集合
            int start = (currrentPage - 1) * rows;
            List<Building> buildingList = buildingDao.findBuildingByPage(start,rows,buildingCondition);

            buildingPageBean.setList(buildingList);

            //计算总页数
            int BuildingPageSum = (buildingTotalCount % rows) == 0 ? buildingTotalCount/rows : (buildingTotalCount/rows) + 1;
            buildingPageBean.setTotalPage(BuildingPageSum);

            return buildingPageBean;
        }
}
