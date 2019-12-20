package com.zm.bean.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/* 自定义的factoryBean需要实现FactoryBean接口 */
public class DeptFactoryBean implements FactoryBean {
    private int deptId;

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    //返回Bean对象
    @Override
    public Object getObject() throws Exception {
        return new Dept(deptId,"市场部");
    }

    //返回Bean的类型
    @Override
    public Class<?> getObjectType() {
        return Dept.class;
    }

    //是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
