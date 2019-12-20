package com.zm.service.impl;

import com.zm.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeDAO {

    EmployeeDAO employeeDAO;

    @Override
    public void say() {
        employeeDAO.say();
    }
}
