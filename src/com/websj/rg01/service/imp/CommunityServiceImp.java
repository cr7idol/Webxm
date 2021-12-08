package com.websj.rg01.service.imp;

import com.websj.rg01.dao.CommunityDao;
import com.websj.rg01.dao.imp.CommunityDaoImp;
import com.websj.rg01.entity.Community;
import com.websj.rg01.service.CommunityService;

import java.util.List;

public class CommunityServiceImp implements CommunityService{
    CommunityDao communityDao = new CommunityDaoImp();

    @Override
    public List<Community> findallCommunities() {
        return communityDao.findallCommunity();
    }

    @Override
    public void updateCommunities(Community community) {
        communityDao.updateCommunity(community);
    }

    @Override
    public void addCommunities(Community community) {
        communityDao.addCommnuity(community);
    }

}
