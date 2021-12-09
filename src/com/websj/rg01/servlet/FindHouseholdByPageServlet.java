package com.websj.rg01.servlet;

import com.websj.rg01.entity.Household;
import com.websj.rg01.entity.PageBean;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.HouseholdServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
/*
  分页查询
 */
@WebServlet("/FindHouseholdByPageServlet")
public class FindHouseholdByPageServlet extends HttpServlet {
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
            Map<String, String[]> condition = request.getParameterMap();

            //调用service查询
            HouseholdService householdService = new HouseholdServiceImp();
            PageBean<Household> householdPageBean = householdService.findhouseholdByPage(currentPage, rows, condition);


            //将pageBean存入request中
            request.setAttribute("householdPageBean",householdPageBean);
            request.setAttribute("condition",condition);

            request.getRequestDispatcher("").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
