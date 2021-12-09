package com.websj.rg01.dao;


import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;


import java.util.List;
import java.util.Map;

public interface CommunityDao {
    public List<Community> findallCommunity();  //查询小区信息

    public void addCommnuity(Community community);//添加小区信息

    public void updateCommunity(Community community);//修改小区信息

    public int findCommnityTotalCount(Map<String,String[]> communityCondition);

    public List<Community> findByPage(int start, int rows, Map<String,String[]> communityCondition);
}
