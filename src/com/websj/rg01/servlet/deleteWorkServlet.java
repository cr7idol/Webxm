package com.websj.rg01.servlet;

import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.WorkService;
import com.websj.rg01.service.imp.StaffServiceImp;
import com.websj.rg01.service.imp.WorkServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteWorkServlet")
public class deleteWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用Service进行删除
        WorkService workService = new WorkServiceImp();
        workService.deleteWorkUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallWorkListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
