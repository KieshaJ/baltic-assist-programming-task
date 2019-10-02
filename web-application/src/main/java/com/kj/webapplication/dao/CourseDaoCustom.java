package com.kj.webapplication.dao;

import com.kj.webapplication.models.Course;
import com.kj.webapplication.utils.filters.CourseFilter;
import org.springframework.data.domain.Page;

public interface CourseDaoCustom {
    Page<Course> list(CourseFilter filter);
}
