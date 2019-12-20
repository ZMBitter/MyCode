package com.zm.web.servlet;

import com.zm.model.Customer;
import com.zm.model.PageBean;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findCustomByPageServlet")
public class FindCustomByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获得当前页码信息
        String curPage = req.getParameter("curPage");//当前页码
        String rows = req.getParameter("rows");//每页显示的条数
        //做一个健壮性的判断
        if(curPage==null||"".equals(curPage)||Integer.parseInt(curPage)<=1){
            curPage = "1";
        }

        if(rows==null||"".equals(rows)){
            rows= "5";
        }

        //获取复杂条件查询的表单数据
        Map<String, String[]> conditionMap = req.getParameterMap();

        UserService service = new UserServiceImpl();
        PageBean<Customer> pageBean = service.findCustomByPage(Integer.parseInt(curPage),Integer.parseInt(rows),conditionMap);
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("condition",conditionMap); //将条件信息保存到req作用域中
        req.getRequestDispatcher("/show.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
