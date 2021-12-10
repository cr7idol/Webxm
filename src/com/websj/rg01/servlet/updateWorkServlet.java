package com.websj.rg01.servlet;

import com.websj.rg01.entity.Staff;
import com.websj.rg01.entity.Work;
import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.WorkService;
import com.websj.rg01.service.imp.StaffServiceImp;
import com.websj.rg01.service.imp.WorkServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateWorkServlet")
public class updateWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();

        Work work = new Work();

        try {
            BeanUtils.populate(work,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        WorkService workService = new WorkServiceImp();
        workService.updateWorkUser(work);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallWorkListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
