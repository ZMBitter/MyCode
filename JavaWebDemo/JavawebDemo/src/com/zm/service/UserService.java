package com.zm.service;

import com.zm.model.Customer;
import com.zm.model.PageBean;
import com.zm.model.User;
import java.util.*;
public interface UserService {
    //展示用户所有信息
    public List<Customer> findAll();
   //用户登陆
    public User login(User user);
    //提交表单信息到数据库中
    boolean save(Customer customer);
    //根据用户id删除
    boolean deleById(int id);
   //根据用户Id查询信息
    Customer finCustomById(int id);
    //修改指定Id的用户信息
    boolean updateCustomer(Customer customer);
    //删除选中
    boolean deleBatch(String[] customIds);
    //获取分页后每页要显示的信息的集合
    PageBean<Customer> findCustomByPage(int curPage, int rows, Map<String, String[]> conditionMap);
}
