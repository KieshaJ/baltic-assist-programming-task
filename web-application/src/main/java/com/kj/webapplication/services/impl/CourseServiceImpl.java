package com.kj.webapplication.services.impl;

import com.kj.webapplication.dao.CourseDao;
import com.kj.webapplication.models.Course;
import com.kj.webapplication.services.CourseService;
import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.CourseDetails;
import com.kj.webapplication.utils.filters.CourseFilter;
import com.kj.webapplication.utils.model.CourseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao dao;

    @Override
    public PagedListWithDetails<CourseDetails> list(CourseFilter filter) {
        Page<Course> page = dao.list(filter);
        PagedListWithDetails<CourseDetails> detailsList = new PagedListWithDetails(page.getSize(), page.getTotalElements(), CourseUtils.toDetailsList(page.getContent()));
        return detailsList;
    }

    @Override
    public CourseDetails get(UUID id) {
        Course entity = dao.findById(id).orElse(null);
        return CourseUtils.toDetails(entity);
    }

    @Override
    public CourseDetails save(CourseDetails details) {
        Course entity = CourseUtils.toEntity(details);
        return CourseUtils.toDetails(dao.save(entity));
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
