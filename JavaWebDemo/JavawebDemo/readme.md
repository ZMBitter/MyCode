<h3>案例：用户信息列表展示</h3>
1. 需求：用户信息的增删改查
2. 设计
  1）技术选型：servlet+jsp+MySQL+JDBCTemplate+Druid+BeanUtils(封装Bean对象)+tomcat
 <br/> 2）数据库设计
  
  ```sql
 create database db4; -- 创建数据库
  use db4; -- 使用数据库
  -- 创建表
  create table if not exists customer( 
    id int(11) primary key auto_increment commit "用户id",
    name varchar(10) not null commit "姓名",
    gender varchar(5) ,
    age int(5),
    address varchar(50),
    qq varchar(15),
    email varchar(20)
  );
```
 3. 开发<br/>
   1）环境的搭建：创建项目，导入所需要的jar包，<br/>
   2）编码<br/>
   <h6>简单功能</h6>
    &emsp;&emsp;列表查询<br/>
    &emsp;&emsp;登陆<br/>
    &emsp;&emsp;添加<br/>
    &emsp;&emsp;删除<br/>
    &emsp;&emsp;修改<br/>
   <h6>复杂功能</h6>
   &emsp;&emsp;删除选中<br/>
    &emsp;&emsp;分页<br/>
    &emsp;&emsp;复杂条件查询<br/>
   
 4. 测试
 
 5. 部署运维
  
  