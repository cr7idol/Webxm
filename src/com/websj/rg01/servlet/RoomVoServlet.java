package com.websj.rg01.servlet;

import com.websj.rg01.entity.vo.RoomVo;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.imp.RoomServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RoomVoServlet")
public class RoomVoServlet extends HttpServlet {  //多表链接后展示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomServiceImp();
        List<RoomVo> allRoom = roomService.getAllRoom();
        ArrayList<String> list = new ArrayList<>();

        for (int a = 0; a < allRoom.size(); a++) {
            RoomVo roomVo = allRoom.get(a);
            list.add(roomVo.toString());
        }
        request.setAttribute("list",list);

        //转发
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
