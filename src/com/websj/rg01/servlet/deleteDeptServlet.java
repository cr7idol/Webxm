package com.websj.rg01.servlet;

import com.websj.rg01.service.DeptService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.DeptServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteDeptServlet")
public class deleteDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用DeptService.del 进行删除
        DeptService deptService = new DeptServiceImp();
        deptService.deletedeptUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallDeptListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
