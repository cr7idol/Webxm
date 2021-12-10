package com.websj.rg01.servlet;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.BuildingService;
import com.websj.rg01.service.CommunityService;
import com.websj.rg01.service.imp.BuildingServiceImp;
import com.websj.rg01.service.imp.CommunityServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindBuildingByPageServlet")
public class FindBuildingByPageServlet extends HttpServlet {
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
        Map<String, String[]> buildingByPageCondition = request.getParameterMap();

        //调用service查询
        BuildingService buildingService = new BuildingServiceImp();
        PageBean<Building> buildingPageBean = buildingService.findBuildingByPage(currentPage, rows, buildingByPageCondition);

        System.out.println(buildingPageBean);

        //将pageBean存入request中
        request.setAttribute("buildingPageBean",buildingPageBean);
        request.setAttribute("buildingByPageCondition",buildingByPageCondition);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
