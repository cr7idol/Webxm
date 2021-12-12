package com.websj.rg01.servlet;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.Work;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.WorkService;
import com.websj.rg01.service.imp.RoomServiceImp;
import com.websj.rg01.service.imp.WorkServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindWorkByPageServlet")
public class FindWorkByPageServlet extends HttpServlet {
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
        Map<String, String[]> workCondition = request.getParameterMap();

        //调用service查询
        WorkService workService = new WorkServiceImp();
        PageBean<Work> workPageBean = workService.findAllWorkByPage(currentPage, rows, workCondition);


        //将pageBean存入request中
        request.setAttribute("workPageBean",workPageBean);
        request.setAttribute("workCondition",workCondition);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
