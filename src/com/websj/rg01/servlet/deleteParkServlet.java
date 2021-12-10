package com.websj.rg01.servlet;

import com.websj.rg01.service.DeptService;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.imp.DeptServiceImp;
import com.websj.rg01.service.imp.ParkServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteParkServlet")
public class deleteParkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用Service进行删除
        ParkService parkService = new ParkServiceImp();
        parkService.deleteParkUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallParkListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
