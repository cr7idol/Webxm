package com.websj.rg01.servlet;

import com.websj.rg01.service.CommunityService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.CommunityServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCommunityServlet")
public class deleteCommunityServlet extends HttpServlet {   //删除
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取id
            int id = Integer.parseInt(request.getParameter("id"));
            //调用householdService.del 进行删除
            CommunityService communityService = new CommunityServiceImp();
            communityService.deleteCommunity(id);

            //跳转到查询所有Servlet
            response.sendRedirect(request.getContextPath()+"/HouseholdListServlet");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
