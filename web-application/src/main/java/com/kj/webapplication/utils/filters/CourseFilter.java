package com.kj.webapplication.utils.filters;

import com.kj.webapplication.utils.enums.SortingOrderEnum;

public class CourseFilter extends OrderedPagedFilter {
    private Integer enrolmentCount;
    private Double priceAmount;

    public CourseFilter(Integer page, Integer pageSize, String orderBy, SortingOrderEnum sortingOrder, Integer enrolmentCount, Double priceAmount) {
        super(page, pageSize, orderBy, sortingOrder);
        this.enrolmentCount = enrolmentCount;
        this.priceAmount = priceAmount;
    }

    public Integer getEnrolmentCount() {
        return enrolmentCount;
    }

    public void setEnrolmentCount(Integer enrolmentCount) {
        this.enrolmentCount = enrolmentCount;
    }

    public Double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(Double priceAmount) {
        this.priceAmount = priceAmount;
    }
}
