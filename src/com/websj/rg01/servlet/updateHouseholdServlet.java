package com.websj.rg01.servlet;

import com.websj.rg01.entity.Household;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.HouseholdServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateHouseholdServlet")
public class updateHouseholdServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取参数
            Map<String, String[]> map = request.getParameterMap();
            Household household = new Household();
            try {
                BeanUtils.populate(household,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用service保存
            HouseholdService householdService = new HouseholdServiceImp();
            householdService.updateHouseholdUser(household);

            //跳转到
            response.sendRedirect(request.getContextPath()+"/FindallHouseholdListServlet");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
