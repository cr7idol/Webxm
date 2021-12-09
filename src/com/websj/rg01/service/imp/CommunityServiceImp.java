package com.websj.rg01.service.imp;

import com.websj.rg01.dao.CommunityDao;
import com.websj.rg01.dao.imp.CommunityDaoImp;
import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.CommunityService;

import java.util.List;
import java.util.Map;

public class CommunityServiceImp implements CommunityService{
    private CommunityDao communityDao = new CommunityDaoImp();

    @Override
    public List<Community> findallCommunities() {
        return communityDao.findallCommunity();
    }

    @Override
    public void deleteCommunity(int id) {communityDao.deleteCommunity(id);}

    @Override
    public void updateCommunities(Community community) {
        communityDao.updateCommunity(community);
    }

    @Override
    public void addCommunities(Community community) {
        communityDao.addCommnuity(community);
    }

    @Override
    public PageBean<Community> findCommunityByPage(String _currentPage, String _rows, Map<String, String[]> communityCondition) {

        int currrentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currrentPage < 0){
            currrentPage = 1;
        }
        //创建空PageBean对象
        PageBean<Community> communityPageBean = new PageBean<>();

        communityPageBean.setCurrentPage(currrentPage);
        communityPageBean.setRows(rows);

        //调用查询总记录数的方法
        int commnityTotalCount = communityDao.findCommnityTotalCount(communityCondition);
        communityPageBean.setTotalCount(commnityTotalCount);

        //调用方法查询List集合
        int start = (currrentPage - 1) * rows;
        List<Community> communityList = communityDao.findByPage(start,rows,communityCondition);

        communityPageBean.setList(communityList);

        //计算总页数
        int communitypagesum = (commnityTotalCount % rows) == 0 ? commnityTotalCount/rows : (commnityTotalCount/rows) + 1;
        communityPageBean.setTotalPage(communitypagesum);

        return communityPageBean;
    }

}
