package com.websj.rg01.servlet;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.entity.Room;
import com.websj.rg01.service.RepairService;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.imp.RepairServiceImp;
import com.websj.rg01.service.imp.RoomServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindRepairByPageServlet")
public class FindRepairByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> repaircondition = request.getParameterMap();

        //调用service查询
        RepairService repairService = new RepairServiceImp();
        PageBean<Repair> repairPageBean = repairService.findRepairByPage(currentPage, rows, repaircondition);


        //将pageBean存入request中
        request.setAttribute("repairPageBean",repairPageBean);
        request.setAttribute("repaircondition",repaircondition);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
