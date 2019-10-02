package com.kj.webapplication.utils.filters;

import com.kj.webapplication.utils.enums.SortingOrderEnum;

public class OrderedPagedFilter extends PagedFilter {
    private String orderBy;
    private SortingOrderEnum sortingOrder;

    protected OrderedPagedFilter() {
        this.orderBy = null;
        this.sortingOrder = null;
    }

    public OrderedPagedFilter(Integer page, Integer pageSize, String orderBy, SortingOrderEnum sortingOrder) {
        super(page, pageSize);
        this.orderBy = orderBy;
        this.sortingOrder = sortingOrder;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public SortingOrderEnum getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(SortingOrderEnum sortingOrder) {
        this.sortingOrder = sortingOrder;
    }
}
