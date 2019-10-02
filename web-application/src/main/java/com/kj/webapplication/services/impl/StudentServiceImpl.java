package com.kj.webapplication.services.impl;

import com.kj.webapplication.dao.CourseDao;
import com.kj.webapplication.dao.EnrolmentDao;
import com.kj.webapplication.dao.StudentDao;
import com.kj.webapplication.models.Course;
import com.kj.webapplication.models.Enrolment;
import com.kj.webapplication.models.Student;
import com.kj.webapplication.services.StudentService;
import com.kj.webapplication.utils.details.CourseEnrolmentDetails;
import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.details.StudentDetails;
import com.kj.webapplication.utils.model.EnrolmentUtils;
import com.kj.webapplication.utils.model.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;
    @Autowired
    private EnrolmentDao enrolmentDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public StudentDetails save(StudentDetails details) {
        Student entity = StudentUtils.toEntity(details);
        return StudentUtils.toDetails(dao.save(entity));
    }

    @Override
    public EnrolmentDetails enrol(UUID studentId, UUID courseId) {
        Student student = dao.getOne(studentId);
        Course course = courseDao.getOne(courseId);
        Enrolment enrolment = null;

        if(student != null && course != null) {
            enrolment = new Enrolment(null, student, course);
        }

        enrolment = enrolmentDao.save(enrolment);

        StudentDetails studentDetails = StudentUtils.toDetails(enrolment.getStudent());
        CourseEnrolmentDetails courseDetails = new CourseEnrolmentDetails(enrolment.getCourse().getId(), enrolment.getCourse().getTitle());

        return new EnrolmentDetails(enrolment.getId(), studentDetails, courseDetails);
    }
}
