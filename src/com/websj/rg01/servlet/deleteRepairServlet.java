package com.websj.rg01.servlet;

import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.RepairService;
import com.websj.rg01.service.imp.ParkServiceImp;
import com.websj.rg01.service.imp.RepairServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteRepairServlet")
public class deleteRepairServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用Service进行删除
        RepairService repairService = new RepairServiceImp();
        repairService.deleteRepairUser(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallRepairListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
