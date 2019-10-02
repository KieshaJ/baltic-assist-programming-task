package com.kj.webapplication.dao;

import com.kj.webapplication.models.Enrolment;
import com.kj.webapplication.utils.filters.EnrolmentFilter;
import org.springframework.data.domain.Page;

public interface EnrolmentDaoCustom {
    Page<Enrolment> list(EnrolmentFilter filter);
}
