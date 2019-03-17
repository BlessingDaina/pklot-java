package com.example.daina.entity;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:09 2019/3/17
 */
public class Page<T> {
    // 当前页
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer count;
    private List<T> items;
    public Page() {
        super();
    }
    public Page(Integer pageNum, Integer pageSize, Integer count) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
