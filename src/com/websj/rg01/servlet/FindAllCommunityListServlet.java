package com.websj.rg01.servlet;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.service.CommunityService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.CommunityServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/FindAllCommunityListServlet")
public class FindAllCommunityListServlet extends HttpServlet {  //查询所有社区信息
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setHeader("content-type", "text/html;charset=UTF-8");
            CommunityService communityService = new CommunityServiceImp();
            List<Community> findallCommunities = communityService.findallCommunities();
            String s = JSON.toJSONString(findallCommunities);
            PrintWriter writer = response.getWriter();
            writer.print(s);
            writer.flush();
            writer.close();
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
