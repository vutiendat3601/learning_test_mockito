package com.datvutech.mockito.service;

import com.datvutech.mockito.dao.EducationDao;
import com.datvutech.mockito.exception.NotAvailableException;
import com.datvutech.mockito.model.Student;

public class EducationService {
    private EducationDao educationDao;

    public EducationService(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    public boolean authenticate(Student student) {
        return educationDao.authenticate(student.getUsername(), student.getPassword());
    }

    public boolean enroll(Student student) {
        educationDao.updateStudent(student);
        return student.isEnrolled();
    }

    public void retrieveTranscript(Student student) throws NotAvailableException {
        if (educationDao.isEnrolled(student)) {
            student.setTranscript(educationDao.getTranscript(student));
        }
    }
}
