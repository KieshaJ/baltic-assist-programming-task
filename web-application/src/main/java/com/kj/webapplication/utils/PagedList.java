package com.kj.webapplication.utils;

import java.io.Serializable;

public class PagedList implements Serializable {
    private int pageSize;
    private long pageCount;
    private long totalElements;

    protected PagedList() {
    }

    public PagedList(int pageSize, long totalElements) {
        if (pageSize <= 0) {
            pageSize = 1;
        }

        int totalPages = (int)(totalElements / (long)pageSize);
        if (totalElements % (long)pageSize != 0L) {
            ++totalPages;
        }

        this.pageSize = pageSize;
        this.pageCount = (long)totalPages;
        this.totalElements = totalElements;
    }

    public long getPageCount() {
        return this.pageCount;
    }

    private void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    private void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    private void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
