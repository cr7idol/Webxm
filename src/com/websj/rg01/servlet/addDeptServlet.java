package com.websj.rg01.servlet;

import com.websj.rg01.entity.Building;
import com.websj.rg01.entity.Dept;
import com.websj.rg01.service.BuildingService;
import com.websj.rg01.service.DeptService;
import com.websj.rg01.service.imp.BuildingServiceImp;
import com.websj.rg01.service.imp.DeptServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addDeptServlet")
public class addDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Dept dept = new Dept();
        try {
            BeanUtils.populate(dept,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        DeptService buildingService = new DeptServiceImp();
        buildingService.adddeptUser(dept);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallDeptListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
