package com.websj.rg01.servlet;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Household;
import com.websj.rg01.service.BuildingService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.BuildingServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindallBuildingListServlet")
public class FindallBuildingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的findallBuilding方法完成查询
        BuildingService buildingService = new BuildingServiceImp();
        List<Building> buildings = buildingService.findallBuilding();
        //讲household存入request域中
        request.setAttribute("buildings",buildings);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
