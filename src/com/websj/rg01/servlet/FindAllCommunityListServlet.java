package com.websj.rg01.servlet;

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
import java.util.List;

@WebServlet("/FindAllCommunityListServlet")
public class FindAllCommunityListServlet extends HttpServlet {  //查询所有社区信息
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            CommunityService communityService = new CommunityServiceImp();
            List<Community> findallCommunities = communityService.findallCommunities();
            //讲findallCommunities存入request域中
            request.setAttribute("findallCommunities",findallCommunities);
            //转发
            request.getRequestDispatcher("").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
