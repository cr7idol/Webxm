package com.websj.rg01.service;

import com.websj.rg01.dao.WorkDao;
import com.websj.rg01.dao.imp.WorkDaoImp;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Work;

import java.util.List;
import java.util.Map;

public interface WorkService {

    public void addWorkUser(Work work);

    public void deleteWorkUser(int id);

    public void updateWorkUser(Work work);

    public List<Work> findAllWorkUser();

    PageBean<Work> findAllWorkByPage(String currentPage, String rows, Map<String,String[]> workCondition);
}
