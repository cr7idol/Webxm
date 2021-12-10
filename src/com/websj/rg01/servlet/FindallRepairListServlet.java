package com.websj.rg01.servlet;

import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.RepairService;
import com.websj.rg01.service.imp.ParkServiceImp;
import com.websj.rg01.service.imp.RepairServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindallRepairListServlet")
public class FindallRepairListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的额findall方法完成查询
        RepairService repairService = new RepairServiceImp();
        List<Repair> repairs = repairService.findAllRepair();
        //讲household存入request域中
        request.setAttribute("repairs",repairs);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
