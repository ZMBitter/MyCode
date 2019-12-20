package com.zm.web.servlet;

import com.zm.model.Customer;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateCustomServlet")
public class UpdateCustomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取表单参数的map集合
        Map<String, String[]> map = req.getParameterMap();
        //创建Customer对象
        Customer customer = new Customer();
        try {//封装Customer对象
            BeanUtils.populate(customer,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("customer对象："+customer);
        //调用service层的updateCustomer(Customer customer)方法，操作数据库
        UserService service = new UserServiceImpl();
        boolean flag = service.updateCustomer(customer);
        if(flag){//修改成功，跳转会show.jsp页面
            System.out.println("修改成功");
            resp.sendRedirect(req.getContextPath()+"/customServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
