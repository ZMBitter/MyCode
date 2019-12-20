package com.zm.dao;

import com.zm.model.Customer;

import java.util.List;
import java.util.Map;

//数据库操作层
public interface CustomerDAO {
    //查询User表里的所有信息
    List<Customer> findAll();
    //插入用户信息
    boolean insertCustomer(Customer customer);
    //根据Id删除用户信息
    boolean deleById(Integer id);
    //根据id查询用户信息
    Customer findCustomById(int id);
    //根据客户Id修改客户信息
    boolean updateCustomerById(Customer customer);
    //批量删除（删除选中）
    boolean deleBatch(String[] customIds);
    //获取数据总记录数
    int getTotalCount(Map<String, String[]> conditionMap);
    //获取分页信息集合
    List<Customer> findCustomByPage(int start, int rows, Map<String,String[]> conditionMap);
}
