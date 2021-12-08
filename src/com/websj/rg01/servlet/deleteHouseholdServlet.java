package com.websj.rg01.servlet;

import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteHouseholdServlet")
public class deleteHouseholdServlet extends HttpServlet {   //删除
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用householdService.del 进行删除
        HouseholdService householdService = new HouseholdServiceImp();
        householdService.deleteHouseholdUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/HouseholdListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
