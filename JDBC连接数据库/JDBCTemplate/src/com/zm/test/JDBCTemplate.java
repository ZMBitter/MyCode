package com.zm.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.zm.bean.User;
import com.zm.utils.DruidUtils;

/*
 * 1.导入jar包
 * 2.创建JdbcTemplate对象
 * 3.创建要执行的sql语句
 * */
public class JDBCTemplate {
	JdbcTemplate template = new JdbcTemplate(DruidUtils.getDaSource());

	// ==================================增、删、改：query================================
	/* 修改 */
	@Test
	public void test01() {
		String sql = "update users set password=? where id=?";
		/*
		 * 第一个参数：要执行的sql语句 第一个参数之后的参数与数据库里面的要一一对应
		 */
		int i = template.update(sql, "aaa", 3);
		System.out.println(i);
	}

	/* 增加一个用户 */
	@Test
	public void test02() {
		String sql = "insert into users(username,password) values(?,?)";
		int i = template.update(sql, "萧萧", "xiaoxiao");
		System.out.println(i);
	}

	/* 删除一个用户的信息 */
	@Test
	public void test03() {
		String sql = "delete from users where id = ?";
		int i = template.update(sql, 7);
		System.out.println(i);
	}

	// ==============================查询queryxxx()=============================

	/*
	 * 根据id查询用户的信息，并将其封装成Map集合
	 * 
	 * 注意：只一条数据。将column作为key，将value作为value
	 */
	@Test
	public void test04() {
		String sql = "select * from users where id = ?";
		Map<String, Object> map = template.queryForMap(sql, 2);
		System.out.println(map);
	}

	/*
	 * 查询数据表users中的所有数据，将其封装成List集合 说明：List集合中，每一个元素是一个Map集合
	 */
	@Test
	public void test05() {
		String sql = "select * from users";
		List<Map<String, Object>> list = template.queryForList(sql);
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	/*封装成javaBean集合:自定义方式 */
	@Test
	public void test06_1() {
		String sql = "select * from users";
		
		List<User> list = template.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		
		for(User u:list){
			System.out.println(u);
		}
	}
	
	/*封装成javaBean对象：使用框架中封装好的方法*/
	@Test
	public void test06_2(){
		//String sql = "select * from users where id = ?";
		String sql = "select * from users";
		/*RowMapper后面的5指预编译sql语句传入的参数*/
		//List<User> list = template.query(sql,new BeanPropertyRowMapper<User>(User.class),5);
		List<User> list = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
		for(User u:list){
        	System.out.println(u);
        }
	}
	
	/*查询总记录数
	 * 
	 * queryForObject可用于聚合函数
	 * */
    @Test
    public void test07(){
    	String sql = "select count(*) from users";
    	Integer count = template.queryForObject(sql, Integer.class);
    	System.out.println(count);
    }
}
