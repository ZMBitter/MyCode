package com.zm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	private static String url = "jdbc:mysql://localhost:3306/stuinformation?characterEncoding=utf-8";
	private static String user = "root";
	private static String pwd = "root";
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static Connection conn;
	private static Statement st;
	private ResultSet rs;

	static {
		try {
			
			Class.forName(driverClass);
		
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static Connection getConnection() {
		return conn;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
