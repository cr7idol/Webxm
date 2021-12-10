package com.websj.rg01.servlet;

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
import java.util.List;

@WebServlet("/FindallStaffListServlet")
public class FindallStaffListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的额findall方法完成查询
        StaffService staffService = new StaffServiceImp();
        List<Staff> staffs = staffService.findAllStaffUser();
        //讲household存入request域中
        request.setAttribute("staffs",staffs);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
