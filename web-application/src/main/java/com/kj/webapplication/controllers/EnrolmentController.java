package com.kj.webapplication.controllers;

import com.kj.webapplication.services.EnrolmentService;
import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.filters.EnrolmentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrolmentController {
    @Autowired
    private EnrolmentService service;

    @PostMapping(path = "/enrolments")
    public PagedListWithDetails<EnrolmentDetails> list(@RequestBody EnrolmentFilter filter) {
        return service.list(filter);
    }
}
