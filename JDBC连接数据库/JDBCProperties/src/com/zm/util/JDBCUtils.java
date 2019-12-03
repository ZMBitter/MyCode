package com.zm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class JDBCUtils {
	private static String driver;//mysql������λ��
	private static String url;//ָʾ���ӵ����ݿ�·��
	private static String user;//�û���
	private static String pwd;//����
	private static Connection conn;
	
	static{
		//��ȡproperties�ļ��е�����
		
		//��ʽһ��ͨ���������ķ�ʽ��ȡjdbc.properties�ļ��е�����
		/*
		 * try {
			//����һ��properties����
			Properties pro = new Properties();
			//��Ҫ�ⲿ���������ļ���·��
			InputStream stream = new FileInputStream(new File("src/jdbc.properties"));
		    //���������ļ�
			pro.load(stream);
			//�������ļ��л�ȡ����ֵ
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			pwd = pro.getProperty("pwd");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		//��ʽ2��ͨ�����������ȡjdbc.properties�ļ��е�����
		/*
		 * try{
			//����һ��properties����
			Properties pro = new Properties();
			//��Ҫ�ⲿ���������ļ���+��׺��
			//JDBCUtils.class JDBCUtils���ʵ��
			InputStream stream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			pro.load(stream);
			
			//�������ļ��ж�ȡ����
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			pwd = pro.getProperty("pwd");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/
		
		//��ʽ3��ͨ��ResourceBundle.getBundle("")��̬������ȡ
		try{
			//��Ҫ�ⲿ�����ļ����ļ���
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			driver = rb.getString("driver");
			url = rb.getString("url");
			user = rb.getString("user");
			pwd = rb.getString("pwd");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//��ȡConnection���Ӷ���
	public static Connection getConnection() throws Exception{
		//ע�����ݿ�����
		Class.forName(driver);
		//ʹ��DriverManager�����ȡ���ݿ����Ӷ���
		conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	
	//�ر�������Դ
	public static void close(Connection conn,Statement st,ResultSet rt) {
		try{
			if(rt!=null){
				rt.close();
			}
			
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				conn.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
