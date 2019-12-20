package com.zm.web.servlet;

import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleBatchServlet")
public class DeleBatchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String[] customIds = req.getParameterValues("customId");
       /* for(String customId:customIds){
            System.out.println(customId);
        }*/
        //调用service层的deleBatch(String[] customIds)方法
        UserService service = new UserServiceImpl();
        boolean flag = service.deleBatch(customIds);
        if(flag){
            System.out.println("删除成功!");
            // resp.sendRedirect(req.getContextPath()+"/customServlet");
            resp.sendRedirect(req.getContextPath()+"/findCustomByPageServlet");
        }else{
            System.out.println("删除失败!");
            req.getRequestDispatcher("/show.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
