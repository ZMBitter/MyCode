package com.zm.bean.autowired;

public class Employee {
    private String name;
    private Integer age;
    private Dept dept;
    private String deptName;
    public Employee() {
    }

    public Employee(String name, Integer age, Dept dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    // 带有bean类型的构造函数
    public Employee(Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


}
