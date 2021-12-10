package com.websj.rg01.servlet;

import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.imp.RoomServiceImp;
import com.websj.rg01.service.imp.StaffServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteStaffServlet")
public class deleteStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用Service进行删除
        StaffService staffService = new StaffServiceImp();
        staffService.deleteStaffUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallStaffListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
