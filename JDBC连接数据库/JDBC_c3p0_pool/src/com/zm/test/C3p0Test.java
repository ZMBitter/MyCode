package com.zm.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.zm.dao.UserDAO;
import com.zm.dao.imp.UserImp;
import com.zm.util.C3p0Utils;

public class C3p0Test {
   @Test
   public void test01(){
	try {
		Connection conn = C3p0Utils.getConn();
		System.out.println(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   @Test
   public void test02(){
	   UserDAO userDAO = new UserImp();
	   int n = userDAO.addUser();
	   System.out.println(n);
   }
}
