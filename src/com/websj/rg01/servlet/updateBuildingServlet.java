package com.websj.rg01.servlet;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Household;
import com.websj.rg01.service.BuildingService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.BuildingServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateBuildingServlet")
public class updateBuildingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Building building = new Building();
        try {
            BeanUtils.populate(building,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        BuildingService buildingService = new BuildingServiceImp();
        buildingService.updateBuilding(building);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallBuildingListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
