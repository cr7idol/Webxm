package com.websj.rg01.servlet;

import com.websj.rg01.entity.Household;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findHouseholdbyidcardServlet")
public class FindHouseholdByIdcardServlet extends HttpServlet {   //按照身份证查询住户
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idacard = request.getParameter("idcard");
        HouseholdService householdService = new HouseholdServiceImp();

        Household householdUser = householdService.findHouseholdUser(idacard);

        request.setAttribute("householdUser",householdUser);

        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
