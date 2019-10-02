package com.kj.webapplication.dao.impl;

import com.kj.webapplication.dao.EnrolmentDaoCustom;
import com.kj.webapplication.models.Course_;
import com.kj.webapplication.models.Enrolment;
import com.kj.webapplication.models.Enrolment_;
import com.kj.webapplication.models.Student_;
import com.kj.webapplication.utils.dao.CustomAbstractDao;
import com.kj.webapplication.utils.filters.EnrolmentFilter;
import com.kj.webapplication.utils.request.PageRequestUtils;
import org.springframework.data.domain.Page;

public class EnrolmentDaoImpl extends CustomAbstractDao<Enrolment> implements EnrolmentDaoCustom {
    @Override
    public Page<Enrolment> list(EnrolmentFilter filter) {
        CustomQuery query = new CustomQuery(Enrolment.class);

        if(filter.getStudentId() != null) {
            query.equalValues(query.root.get(Enrolment_.student).get(Student_.id), filter.getStudentId());
        }

        if(filter.getCourseId() != null) {
            query.equalValues(query.root.get(Enrolment_.course).get(Course_.id), filter.getCourseId());
        }

        return query.getPageResult(PageRequestUtils.newPageRequest(filter));
    }
}
