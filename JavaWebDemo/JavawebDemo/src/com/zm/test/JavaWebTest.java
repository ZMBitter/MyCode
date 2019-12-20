package com.zm.test;

import com.zm.dao.CustomerDAO;
import com.zm.dao.UserDAO;
import com.zm.dao.impl.CustomerDAOImpl;
import com.zm.dao.impl.UserDAOImpl;
import com.zm.model.Customer;
import com.zm.model.PageBean;
import com.zm.model.User;
import com.zm.service.UserService;
import com.zm.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaWebTest {

    @Test
    public void findByNameAndPasswordTest1(){
       UserService service = new UserServiceImpl();
       User user = new User();
       user.setUsername("admin");
       user.setPassword("admin");
        User login = service.login(user);
        System.out.println(login);
    }

    @Test
    public void findByNameAndPasswordTest2(){
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        User loginUser = userDAO.findUserByNameAndPassword(user);
        System.out.println(loginUser);
    }

    @Test
    public void addTest(){
      UserService service = new UserServiceImpl();
      Customer customer = new Customer();
      customer.setName("张兰");
      customer.setGender("女");
      customer.setAge(20);
      customer.setAddress("四川");
      customer.setQq("123095678");
      customer.setEmail("123095678@qq.com");
      boolean flag = service.save(customer);
      System.out.println(flag);
    }

    //修改客户信息
    @Test
    public void updateTest(){
        UserService service = new UserServiceImpl();
        Customer customer = new Customer(1,"小明","男",20,"山西","345677890","345677890@qq.com");
        boolean flag = service.updateCustomer(customer);
        System.out.println("是否成功修改?"+flag);
    }


    //删除选中。拼接字符串测试
    @Test
    public void deleTest(){
        CustomerDAO customerDAO = new CustomerDAOImpl();
        String[] customIds = {"1","3","4"};
        customerDAO.deleBatch(customIds);
    }


    //测试分页显示数据
    @Test
    public void pageTest(){
        UserService service = new UserServiceImpl();
        //CustomerDAO customerDAO = new CustomerDAOImpl();
        Map<String,String[]> map = new HashMap<>();
        String[] name={"admin"};
        String[] email = {"123456@qq.com"};
        String[] address = {"山东"};
        map.put("name",name);
        map.put("email",email);
       // map.put("address",address);
        PageBean<Customer> customByPage = service.findCustomByPage(1, 5, map);
        //  System.out.println(pageBean);
    }
}
