package com.datvutech.mockito.dao;

import com.datvutech.mockito.exception.NotAvailableException;
import com.datvutech.mockito.model.Student;

public class EducationDao {
    public boolean authenticate(String username, String password) {
        return false;
    }

    public void updateStudent(Student student) {
    }

    public String getTranscript(Student student) throws NotAvailableException {
        return student.getTranscript();
    }

    public boolean isEnrolled(Student student) {
        return student.isEnrolled();
    }
}
