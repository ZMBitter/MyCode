package com.zm.dao;

import com.zm.model.User;

public interface UserDAO {
    //根据用户名和密码查找User对象
    User findUserByNameAndPassword(User user);
}
