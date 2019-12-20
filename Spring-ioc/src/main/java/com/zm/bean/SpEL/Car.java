package com.zm.bean.SpEL;

public class Car {
    private String brand; //品牌
    private int saleCount; //销售量
    private double price; //售价
    private int yearCount; //年销售量
    private boolean flag;  //是否是最新款

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", saleCount=" + saleCount +
                ", price=" + price +
                ", yearCount=" + yearCount +
                ", flag=" + flag +
                '}';
    }
}
