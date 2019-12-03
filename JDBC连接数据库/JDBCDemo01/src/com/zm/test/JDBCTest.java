package com.zm.test;

import java.util.List;

import org.junit.Test;

import com.zm.bean.User;
import com.zm.dao.UserDao;

public class JDBCTest {
	@Test
	public void jdbcTest01(){
		UserDao userDao = new UserDao();
		List<User> list = userDao.selectUser();
		System.out.println(list);
	}
}
