package com.websj.rg01.servlet;

import com.websj.rg01.entity.Staff;
import com.websj.rg01.entity.Work;
import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.WorkService;
import com.websj.rg01.service.imp.StaffServiceImp;
import com.websj.rg01.service.imp.WorkServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindallWorkServlet")
public class FindallWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的额findall方法完成查询
        WorkService workService = new WorkServiceImp();
        List<Work> works = workService.findAllWorkUser();
        //讲household存入request域中
        request.setAttribute("works",works);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
