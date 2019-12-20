package com.zm.dao.impl;

import com.zm.dao.UserDAO;
import com.zm.model.User;
import com.zm.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.temporal.Temporal;

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDaSource());

    @Override
    public User findUserByNameAndPassword(User user) {
        String sql = "select * from user where username=? and password=?";
        User loginUser = null;
        try{
            loginUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        }catch (Exception e){

        }
        return loginUser;
    }
}
