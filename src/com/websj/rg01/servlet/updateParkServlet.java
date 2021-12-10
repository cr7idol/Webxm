package com.websj.rg01.servlet;

import com.websj.rg01.entity.Dept;
import com.websj.rg01.entity.Park;
import com.websj.rg01.service.DeptService;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.imp.DeptServiceImp;
import com.websj.rg01.service.imp.ParkServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateParkServlet")
public class updateParkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Park park = new Park();
        try {
            BeanUtils.populate(park,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        ParkService parkService = new ParkServiceImp();
        parkService.updateParkUser(park);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallParkListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
