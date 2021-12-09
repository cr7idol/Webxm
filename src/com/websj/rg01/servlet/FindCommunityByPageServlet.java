package com.websj.rg01.servlet;

import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.CommunityService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.CommunityServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindCommunityByPageServlet")
public class FindCommunityByPageServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");

            //获取参数
            String currentPage = request.getParameter("currentPage");
            String rows = request.getParameter("rows");

            if (currentPage == null || "".equals(currentPage)){
                currentPage = "1";
            }

            if (rows == null || "".equals(rows)){
                rows = "5";
            }

            //获取条件查询参数
            Map<String, String[]> communityByPageCondition = request.getParameterMap();

            //调用service查询
            CommunityService communityService = new CommunityServiceImp();
            PageBean<Community> communityPageBean = communityService.findCommunityByPage(currentPage, rows, communityByPageCondition);

            System.out.println(communityPageBean);

            //将pageBean存入request中
            request.setAttribute("communityPageBean",communityPageBean);
            request.setAttribute("communityByPageCondition",communityByPageCondition);

            request.getRequestDispatcher("").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
