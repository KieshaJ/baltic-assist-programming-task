package com.kj.webapplication.dao;

import com.kj.webapplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentDao extends JpaRepository<Student, UUID>, StudentDaoCustom {
}
