package com.websj.rg01.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.parsers.SAXParser;
import java.io.*;

@WebServlet(urlPatterns = "/UpdateJsonServlet")
public class UpdateJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String info = request.getParameter("info");

        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        String webappRoot = classpath.replaceAll("WEB-INF/classes/", "");
        File file = new File(webappRoot+request.getParameter("url"));
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
        int ch = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            stringBuffer.append((char) ch);
        }
        fileReader.close();
        reader.close();
        String s = stringBuffer.toString();
        int i = s.indexOf("[");
        String substring = s.substring(0, i);
        String newJson = substring+info+"}";
        if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
            file.getParentFile().mkdirs();
        }
        if (file.exists()) { // 如果已存在,删除旧文件
            file.delete();
        }
        file.createNewFile();
        Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        write.write(newJson);
        write.flush();
        write.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
