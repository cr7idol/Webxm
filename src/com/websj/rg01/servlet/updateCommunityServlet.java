package com.websj.rg01.servlet;

import com.websj.rg01.entity.Community;
import com.websj.rg01.entity.Household;
import com.websj.rg01.service.CommunityService;
import com.websj.rg01.service.HouseholdService;
import com.websj.rg01.service.imp.CommunityServiceImp;
import com.websj.rg01.service.imp.HouseholdServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateCommunityServlet")
public class updateCommunityServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取参数
            Map<String, String[]> map = request.getParameterMap();
            Community community = new Community();
            try {
                BeanUtils.populate(community,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用service保存
            CommunityService communityService = new CommunityServiceImp();
            communityService.updateCommunities(community);

            //跳转到
            response.sendRedirect(request.getContextPath()+"/FindAllCommunityListServlet");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request, response);
        }
}
