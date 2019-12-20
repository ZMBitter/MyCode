package com.zm.dao.impl;

import com.zm.dao.CustomerDAO;
import com.zm.model.Customer;
import com.zm.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*使用JDBCTemplate获得数据库连接池，从而对表进行操作*/
public class CustomerDAOImpl implements CustomerDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDaSource());

    //根据id删除用户信息
    @Override
    public boolean deleById(Integer id) {
        String sql = "delete from customer where id=?";
        int dele = template.update(sql, id);

        if(dele>0){
            return true;
        }
        return false;
    }

    //将customer信息保存到customer表中
    @Override
    public boolean insertCustomer(Customer customer) {
        String sql = "insert into customer(id,`name`,gender,age,address,qq,email) values(null,?,?,?,?,?,?)";
        int update = template.update(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getAddress(), customer.getQq(), customer.getEmail());
        if(update>0){
            return true;
        }
        return false;
    }

    //根据id查询客户信息
    @Override
    public Customer findCustomById(int id) {
        String sql = "select * from customer where id=?";
        Customer customer = template.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), id);
        return customer;
    }

    //根据客户Id修改客户信息
    @Override
    public boolean updateCustomerById(Customer customer) {
        String sql = "update customer set gender=?,age=?,address=?,qq=?,email=? where id=?";
        int update = template.update(sql, customer.getGender(), customer.getAge(), customer.getAddress(), customer.getQq(), customer.getEmail(), customer.getId());
        if(update>0){
            return true;
        }
        return false;
    }

    //批量删除(删除选中)
    @Override
    public boolean deleBatch(String[] customIds) {
        String sql = "delete from customer where 1=1 and id in(";
        for(String customId:customIds){
            int id = Integer.parseInt(customId);
            sql += id+",";
        }
        sql = sql.substring(0,sql.length()-1)+")";

        //执行批量删除
        int dele = template.update(sql);
        if(dele>0){//删除成功
            return true;
        }
        return false;
    }

    //获取总记录数
    @Override
    public int getTotalCount(Map<String, String[]> conditionMap) {
        String sql = "select count(*) from customer where 1=1 ";

        StringBuffer sb = new StringBuffer(sql);
        List<Object> parms = new ArrayList<>();//存放参数

        for(String key:conditionMap.keySet()){
            //排除curPage与rows在sql语句种的拼接
            if("curPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String val = conditionMap.get(key)[0];
            if(val != null && !"".equals(val)){
               sb.append(" and "+key+" like ?");
               parms.add("%"+val+"%");
            }
            sql = sb.toString();
        }
       System.out.println(sql);
        System.out.println(parms);
       int totalCount = template.queryForObject(sql, Integer.class,parms.toArray());
       return totalCount;
        //return 0;
    }

    //查询所有用户信息
    @Override
    public List<Customer> findAll() {
        String sql = "select * from customer";
        List<Customer> customerList = null;
        try{
            customerList = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerList;
    }

    //获取分页信息集合
    @Override
    public List<Customer> findCustomByPage(int start, int rows, Map<String,String[]> conditionMap) {
        String sql = "select * from customer where 1=1 ";
        StringBuffer sb = new StringBuffer(sql);
        List<Object> parms = new ArrayList<>();//存放参数

        for(String key:conditionMap.keySet()){
            if("curPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String val = conditionMap.get(key)[0];
            if(val != null && !"".equals(val)){
                sb.append(" and "+ key +" like ?");
                parms.add("%"+val+"%");
            }
        }
        sb.append(" limit ?,?");//拼接模糊查询
        parms.add(start);
        parms.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(parms);
        List<Customer> list = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class), parms.toArray());
        return list;
        //return null;
    }
}
