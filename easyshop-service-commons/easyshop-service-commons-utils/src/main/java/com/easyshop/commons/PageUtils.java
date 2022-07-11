package com.easyshop.commons;


import java.util.ArrayList;
import java.util.List;

/**
 * 分页的工具类(通用的)
 */

public class PageUtils<T> {

    private Long pageIndex; //当前页码
    private Long pageSize; //页码大小
    private Long pageCount; //总页数
    private Long totalCount; //总条数

    private List<T> records; //每页的数据


    private Long beginNumber; //开始序号
    private Long endNumber; //结束序号

    public PageUtils(){

    }

    //存储的是分页的序号
    private List<Long> numbers = new ArrayList<Long>();

    public PageUtils(Long pageIndex, Long pageSize, Long totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = records;
        //人工计算总页数
        this.pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize) + 1;

        //给序号集合初始化下
       if (this.pageCount <= 10) {
            this.beginNumber = 1L;
            this.endNumber = pageCount;
        } else {
            this.beginNumber = pageIndex - 4;
            this.endNumber = pageIndex + 5;
            if (beginNumber < 1) {
                this.beginNumber = 1L;
                this.endNumber = 10L;
            } else if (endNumber > pageCount) {
                this.endNumber = pageCount;
                this.beginNumber = pageCount - 9;
            }
        }


        for (Long i = beginNumber; i <= endNumber; i++) {
            numbers.add(i);
        }

    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getBeginNumber() {
        return beginNumber;
    }

    public void setBeginNumber(Long beginNumber) {
        this.beginNumber = beginNumber;
    }

    public Long getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Long endNumber) {
        this.endNumber = endNumber;
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", records=" + records +
                ", beginNumber=" + beginNumber +
                ", endNumber=" + endNumber +
                ", numbers=" + numbers +
                '}';
    }
}
