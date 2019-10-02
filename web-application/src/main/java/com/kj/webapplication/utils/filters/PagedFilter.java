package com.kj.webapplication.utils.filters;

public class PagedFilter {
    private Integer page;
    private Integer pageSize;

    protected PagedFilter() {
        this.setPage((Integer)null);
        this.setPageSize((Integer)null);
    }

    public PagedFilter(Integer page, Integer pageSize) {
        this.setPage(page);
        this.setPageSize(pageSize);
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            page = 1;
        }

        this.page = page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }

        this.pageSize = pageSize;
    }
}
