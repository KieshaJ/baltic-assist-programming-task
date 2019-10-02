package com.kj.webapplication.controllers;

import com.kj.webapplication.services.CourseService;
import com.kj.webapplication.utils.PagedListWithDetails;
import com.kj.webapplication.utils.details.CourseDetails;
import com.kj.webapplication.utils.filters.CourseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping(path = "/courses")
    public PagedListWithDetails<CourseDetails> list(@RequestBody CourseFilter filter) {
        return service.list(filter);
    }

    @GetMapping(path = "/course/{id}")
    public CourseDetails get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PostMapping(path = "/course")
    public CourseDetails save(@RequestBody CourseDetails details) {
        return service.save(details);
    }

    @DeleteMapping(path = "/course/{id}")
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
