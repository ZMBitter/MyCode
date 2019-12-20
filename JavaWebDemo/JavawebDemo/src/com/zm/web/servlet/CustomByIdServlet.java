package com.zm.web.servlet;


import com.zm.model.Customer;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customByIdServlet")  //根据id查询用户信息。查询的是需要在修改表单中回显的信息
public class CustomByIdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取用户id信息
        int id = Integer.parseInt(req.getParameter("id"));
        //在service层中，调用相关方法，返回Customer对象
        UserService service = new UserServiceImpl();
        Customer customer = service.finCustomById(id);
        //将Customer对象信息保存到req作用域中，发送到update.jsp页面
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
