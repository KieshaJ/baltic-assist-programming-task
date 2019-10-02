package com.kj.webapplication.services;

import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.filters.EnrolmentFilter;

public interface EnrolmentService {
    PagedListWithDetails<EnrolmentDetails> list(EnrolmentFilter filter);
}
