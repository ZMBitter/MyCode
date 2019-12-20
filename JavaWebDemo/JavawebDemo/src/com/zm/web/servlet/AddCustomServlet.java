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

@WebServlet("/addCustomServlet")  //添加用户信息
public class AddCustomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单信息的map集合
        Map<String, String[]> map = req.getParameterMap();
        //创建Customer对象
        Customer customer = new Customer();
        try {
            //封装Customer对象
            BeanUtils.populate(customer,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("customer对象："+customer);
        //使用service层调用saveCustomer(Customer customer)方法将数据提交到数据表customer中
        UserService service = new UserServiceImpl();
        boolean flag = service.save(customer);
        if(flag){//添加成功，跳转到show.jsp页面
            System.out.println("添加成功!");
            //resp.sendRedirect(req.getContextPath()+"/customServlet");
            resp.sendRedirect(req.getContextPath()+"/findCustomByPageServlet");
        }else{//添加失败
            System.out.println("添加失败!");
            req.getRequestDispatcher("/add.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
