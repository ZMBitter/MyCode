package com.zm.dao;

import java.util.List;

import com.zm.bean.User;

public interface UserDAO {
   /*查询数据库里面用户的信息*/
   List<User> selUser();
}
