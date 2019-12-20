package com.zm.dao.impl;

import com.zm.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void say() {
        System.out.println("Hello，Spring!");
    }
}
