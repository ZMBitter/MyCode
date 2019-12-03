package com.zm.test;

import java.util.List;

import org.junit.Test;

import com.zm.bean.User;
import com.zm.userdao.UserDao;

public class PropertiesTest {
	@Test
	public void proTest() throws Exception{
		UserDao userDao = new UserDao();
		List<User> list = userDao.select();
		for(User u:list){
			System.out.println(u);
		}
	}

	@Test
	public void addTest() throws Exception{
		UserDao userDao = new UserDao();
		userDao.addUser("ะกร๗", "admin");
	}
}
