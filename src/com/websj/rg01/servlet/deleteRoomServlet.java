package com.websj.rg01.servlet;

import com.websj.rg01.service.RepairService;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.imp.RepairServiceImp;
import com.websj.rg01.service.imp.RoomServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteRoomServlet")
public class deleteRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //调用Service进行删除
        RoomService roomService = new RoomServiceImp();
        roomService.deleteRoomList(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/FindallRoomListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
