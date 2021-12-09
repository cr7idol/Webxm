package com.websj.rg01.service;

import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface CommunityService {
    public List<Community> findallCommunities(); //查新小区信息

    public void deleteCommunity(int id); //删除小区信息

    public void updateCommunities(Community community); //修改小区信息

    public void addCommunities(Community community);  //添加小区信息,保存小区信息

    PageBean<Community> findCommunityByPage(String currentPage, String rows, Map<String,String[]> communityCondition);
}
