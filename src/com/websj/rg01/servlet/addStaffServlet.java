package com.websj.rg01.servlet;

import com.websj.rg01.entity.Room;
import com.websj.rg01.entity.Staff;
import com.websj.rg01.service.RoomService;
import com.websj.rg01.service.StaffService;
import com.websj.rg01.service.imp.RoomServiceImp;
import com.websj.rg01.service.imp.StaffServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addStaffServlet")
public class addStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Staff staff = new Staff();
        try {
            BeanUtils.populate(staff,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service保存
        StaffService staffService = new StaffServiceImp();
        staffService.addStaffUser(staff);

        //跳转到
        response.sendRedirect(request.getContextPath()+"/FindallStaffListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
