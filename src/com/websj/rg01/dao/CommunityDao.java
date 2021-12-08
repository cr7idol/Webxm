package com.websj.rg01.dao;


import com.websj.rg01.entity.Community;


import java.util.List;

public interface CommunityDao {
    public List<Community> findallCommunity();  //查询小区信息

    public void addCommnuity(Community community);//添加小区信息

    public void updateCommunity(Community community);//修改小区信息


}
