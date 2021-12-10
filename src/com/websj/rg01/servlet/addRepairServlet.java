package com.websj.rg01.servlet;

import com.websj.rg01.entity.Park;
import com.websj.rg01.entity.Repair;
import com.websj.rg01.service.ParkService;
import com.websj.rg01.service.RepairService;
import com.websj.rg01.service.imp.ParkServiceImp;
import com.websj.rg01.service.imp.RepairServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addRepairServlet")
public class addRepairServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Repair repair = new Repair();
        try {
            BeanUtils.populate(repair,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        RepairService repairService = new RepairServiceImp();
        repairService.addRepairUser(repair);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallRepairListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
