package com.kj.webapplication.services;

import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.CourseDetails;
import com.kj.webapplication.utils.filters.CourseFilter;

import java.util.UUID;

public interface CourseService {
    PagedListWithDetails<CourseDetails> list(CourseFilter filter);
    CourseDetails get(UUID id);
    CourseDetails save(CourseDetails details);
    Boolean delete(UUID id);
}
