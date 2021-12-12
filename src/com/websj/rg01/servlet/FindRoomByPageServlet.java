package com.websj.rg01.servlet;

import com.websj.rg01.entity.PageBean;
import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Room;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.imp.ParkServiceImp;
import com.websj.rg01.service.imp.RoomServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/FindRoomByPageServlet")
public class FindRoomByPageServlet extends HttpServlet {
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
        Map<String, String[]> roomcondition = request.getParameterMap();

        //调用service查询
        RoomService roomService = new RoomServiceImp();
        PageBean<Room> roomPageBean = roomService.findRoomByPage(currentPage, rows, roomcondition);


        //将pageBean存入request中
        request.setAttribute("roomPageBean",roomPageBean);
        request.setAttribute("roomcondition",roomcondition);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
