package com.zm.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.zm.bean.User;
import com.zm.dao.UserDAO;
import com.zm.dao.imp.UserImp;
import com.zm.utils.DruidUtils;

public class DruidTest {
   @Test
   public void test01(){
	   try {
		Connection conn = DruidUtils.getConn();
		System.out.print(conn);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
   }
   
   @Test
   public void selTest(){
	   UserDAO userDAO = new UserImp();
	   List<User> list = userDAO.selUser();
	  System.out.println(list);
   }
}
