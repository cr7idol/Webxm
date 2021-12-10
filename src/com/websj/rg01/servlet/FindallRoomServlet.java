package com.websj.rg01.servlet;

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
import java.util.List;

@WebServlet("/FindallRoomServlet")
public class FindallRoomServlet extends HttpServlet { //查询room表中的所有信息
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的额findall方法完成查询
        RoomService roomService = new RoomServiceImp();
        List<Room> rooms = roomService.findAllRoomListQuery();
        //讲household存入request域中
        request.setAttribute("rooms",rooms);
        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
