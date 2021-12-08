package com.websj.rg01.service;

import com.websj.rg01.entity.Community;

import java.util.List;

public interface CommunityService {
    public List<Community> findallCommunities(); //查新小区信息

    public void updateCommunities(Community community); //修改小区信息

    public void addCommunities(Community community);  //添加小区信息
}
