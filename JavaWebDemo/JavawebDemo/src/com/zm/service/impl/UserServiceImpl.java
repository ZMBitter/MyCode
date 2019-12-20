package com.zm.service.impl;

import com.zm.dao.CustomerDAO;
import com.zm.dao.UserDAO;
import com.zm.dao.impl.CustomerDAOImpl;
import com.zm.dao.impl.UserDAOImpl;
import com.zm.model.Customer;
import com.zm.model.PageBean;
import com.zm.model.User;
import com.zm.service.UserService;
import java.util.List;
import java.util.Map;

public class UserServiceImpl  implements UserService {
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();

    //展示所有用户信息
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = customerDAO.findAll();
        return customerList;
    }

    //用户登陆
    @Override
    public User login(User user) {
        User loginUser = userDAO.findUserByNameAndPassword(user);
        return loginUser;
    }

    //根据id删除用户信息
    @Override
    public boolean deleById(int id) {
        boolean flag = customerDAO.deleById(id);
        return flag;
    }

    //根据ID查询Customer对象
    @Override
    public Customer finCustomById(int id) {
       Customer customer = customerDAO.findCustomById(id);
        return customer;
    }

    //修改指定客户Id的客户信息
    @Override
    public boolean updateCustomer(Customer customer) {
       boolean flag = customerDAO.updateCustomerById(customer);
        return flag;
    }

    //批量删除(删除选中)
    @Override
    public boolean deleBatch(String[] customIds) {
        boolean flag = customerDAO.deleBatch(customIds);
        return flag;
    }

    //显示分页信息的集合
    @Override
    public PageBean<Customer> findCustomByPage(int curPage, int rows, Map<String, String[]> conditionMap) {
        //1.创建一个空的PageBean对象
        PageBean<Customer> pageBean = new PageBean<Customer>();
        //2. 获取总记录数
        int totalCount = customerDAO.getTotalCount(conditionMap);
       //3.获取总页码
        int totalPage = totalCount%rows==0?totalCount/rows:totalCount/rows+1;

       //4.查询分页显示信息的集合
        //4.1 计算每页的起始记录数
        int start = (curPage-1)*rows;
        //4.2 调用findCustomByPage(start,rows)
        List<Customer>  list = customerDAO.findCustomByPage(start,rows,conditionMap);

        pageBean.setCurPage(curPage);
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);

        return pageBean;
    }

    //添加用户信息
    @Override
    public boolean save(Customer customer) {
        boolean flag = customerDAO.insertCustomer(customer);
        return flag;
    }
}
