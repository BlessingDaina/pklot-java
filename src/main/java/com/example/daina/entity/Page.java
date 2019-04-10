package com.example.daina.entity;

import java.util.List;
import java.util.Map;

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
    private List<Map<String, Object>> recordItems;
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

    public List<Map<String, Object>> getRecordItems() {
        return recordItems;
    }

    public void setRecordItems(List<Map<String, Object>> recordItems) {
        this.recordItems = recordItems;
    }
}
