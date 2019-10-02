package com.kj.webapplication.services.impl;

import com.kj.webapplication.dao.EnrolmentDao;
import com.kj.webapplication.models.Enrolment;
import com.kj.webapplication.services.EnrolmentService;
import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.filters.EnrolmentFilter;
import com.kj.webapplication.utils.model.EnrolmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {
    @Autowired
    private EnrolmentDao dao;

    @Override
    public PagedListWithDetails<EnrolmentDetails> list(EnrolmentFilter filter) {
        Page<Enrolment> page = dao.list(filter);
        PagedListWithDetails<EnrolmentDetails> detailsList = new PagedListWithDetails(page.getSize(), page.getTotalElements(), EnrolmentUtils.toDetailsList(page.getContent()));
        return detailsList;
    }
}
