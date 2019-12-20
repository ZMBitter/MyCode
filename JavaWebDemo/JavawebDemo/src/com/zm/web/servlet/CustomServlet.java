package com.zm.web.servlet;

import com.zm.model.Customer;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/customServlet")  //查询用户所有信息
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //调用service业务逻辑层，获得User集合，将其保存到session作用域中，转发到show.jsp页面中
        UserService userService = new UserServiceImpl();
        List<Customer> customerList = userService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
