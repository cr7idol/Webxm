package com.websj.rg01.servlet;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.imp.RoomServiceImp;
import com.websj.rg01.service.imp.StaffServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindStaffByPageServlet")
public class FindStaffByPageServlet extends HttpServlet {
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
        Map<String, String[]> staffCondition = request.getParameterMap();

        //调用service查询
        StaffService staffService = new StaffServiceImp();
        PageBean<Staff> staffPageBean = staffService.findStaffByPageUser(currentPage, rows, staffCondition);


        //将pageBean存入request中
        request.setAttribute("staffPageBean",staffPageBean);
        request.setAttribute("staffCondition",staffCondition);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
