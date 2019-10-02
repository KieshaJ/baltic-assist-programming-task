package com.kj.webapplication.dao.impl;

import com.kj.webapplication.dao.CourseDaoCustom;
import com.kj.webapplication.models.Course;
import com.kj.webapplication.models.Course_;
import com.kj.webapplication.models.Price_;
import com.kj.webapplication.utils.dao.CustomAbstractDao;
import com.kj.webapplication.utils.enums.SortingOrderEnum;
import com.kj.webapplication.utils.filters.CourseFilter;
import com.kj.webapplication.utils.request.PageRequestUtils;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.domain.Page;

public class CourseDaoImpl extends CustomAbstractDao<Course> implements CourseDaoCustom{
    @Override
    public Page<Course> list(CourseFilter filter) {
        CustomQuery query = new CustomQuery(Course.class);

        if(filter.getPriceAmount() != null) {
            query.equalValues(query.root.get(Course_.price).get(Price_.amount), filter.getPriceAmount());
        }

        if(filter.getEnrolmentCount() != null) {
            query.equalValues(query.root.get(Course_.enrolmentCount), filter.getEnrolmentCount());
        }

        if(filter.getOrderBy() != null) {
            if(filter.getOrderBy().equals("enrolmentCount")) {
                query.addOrder(new OrderImpl(query.root.get(Course_.enrolmentCount), filter.getSortingOrder().equals(SortingOrderEnum.asc)));
            }
            if(filter.getOrderBy().equals("priceAmount")) {
                query.addOrder(new OrderImpl(query.root.get(Course_.price).get(Price_.amount), filter.getSortingOrder().equals(SortingOrderEnum.asc)));
            }
        }

        return query.getPageResult(PageRequestUtils.newPageRequest(filter));
    }
}
