package com.zm.web.servlet;

import com.zm.model.User;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/deleCustomServlet")  //单个删除
public class DeleCustomServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        UserService service = new UserServiceImpl();
       boolean flag =  service.deleById(id);
       if(flag){//删除成功，重新跳转到查询所有用户的servlet(customServlet)
           System.out.println("删除成功，删除的用户id为："+id);

           //resp.sendRedirect(req.getContextPath()+"/customServlet");
           resp.sendRedirect(req.getContextPath()+"/findCustomByPageServlet");
       }else{//删除失败
           System.out.println("删除失败！");
           req.getRequestDispatcher("/show.jsp");
       }

    }
}
