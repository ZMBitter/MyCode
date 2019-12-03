package com.zm.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.zm.dao.UserDao;
import com.zm.utils.DBCPUtil;
import com.zm.utils.JdbcUtils;

public class DBCPTest {
	@Test
	public void connTest() throws Exception{
		Connection conn = DBCPUtil.getConnection();
		//Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void dbcpTest() throws SQLException{
		//��ȡConnection���Ӷ���
		Connection conn =null;
		for(int i=0;i<20;i++){
			//conn = JdbcUtils.getConnection();
			conn = DBCPUtil.getConnection();
			System.out.println((i+1)+","+conn);
			//conn.close();
			DBCPUtil.closeConn();
		}
		
	}
	
	
	@Test
	public void selectTest(){
		UserDao userDao = new UserDao();
		userDao.select();
	}

}
