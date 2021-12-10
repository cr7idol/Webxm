package com.websj.rg01.servlet;

import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.Park;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.imp.HouseholdServiceImp;
import com.websj.rg01.service.imp.ParkServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindallParkListServlet")
public class FindallParkListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的额findall方法完成查询
        ParkService parkService = new ParkServiceImp();
        List<Park> parks = parkService.findAllParkUser();
        //讲household存入request域中
        request.setAttribute("parks",parks);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
