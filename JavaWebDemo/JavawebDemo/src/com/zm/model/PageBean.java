package com.zm.model;

import java.io.Serializable;
import java.util.List;

//分页对象
public class PageBean<T> implements Serializable {
    private Integer totalCount; //总记录数 select count(*) from customers;
    private Integer rows; //每一页显示的记录数
    private Integer totalPage; //总页码 totalPage = totalCount%rows==0?totalCount/rows:totalCount/rows+1
    private List<T> list; //每页要显示的数据集合
    private Integer curPage;  //当前页。

    public PageBean() {

    }

    public PageBean(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currPage=" + curPage +
                '}';
    }
}
