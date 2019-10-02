package com.kj.webapplication.dao;

import com.kj.webapplication.models.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnrolmentDao extends JpaRepository<Enrolment, UUID>, EnrolmentDaoCustom {
}
