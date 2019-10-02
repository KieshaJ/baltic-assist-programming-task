package com.kj.webapplication.dao;

import com.kj.webapplication.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseDao extends JpaRepository<Course, UUID>, CourseDaoCustom {
}
