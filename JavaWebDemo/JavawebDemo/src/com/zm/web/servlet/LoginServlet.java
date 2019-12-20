package com.zm.web.servlet;

import com.zm.model.Customer;
import com.zm.model.User;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*用户登陆功能的servlet*/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.设置字符编码*/
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        /*2.获取login.jsp表单中的验证码*/
        String checkCode = req.getParameter("checkCode"); //验证码

        /*3. 登陆验证*/
        //3.1 先判断输入的验证码是否正确。问题：如何获取图片上的验证码的内容？
        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");  //确保验证码的一次性
        if(!checkCode.equalsIgnoreCase(checkCode_session)){//验证码输入不正确
            session.setAttribute("login_msg","<font color='red' size='2'>验证码输入不正确</font>");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }

      // 4. 普通方法封装User对象
       /* String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username="+username+",password="+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);*/

       //使用BeanUtils封装对象
               Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*5. 调用service层的login(User user)方法，进行用户名和密码的验证*/
        UserService userService = new UserServiceImpl();
        User loginUser =  userService.login(user);
        if(loginUser !=null){
            session.setAttribute("login_msg","<font color='green' size='2'>登陆成功</font>");
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{//将用户存入session，跳转页面
            session.setAttribute("login_msg","<font color='red' size='2'>用户名或密码不正确</font>");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
