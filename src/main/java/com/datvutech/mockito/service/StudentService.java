package com.datvutech.mockito.service;

import com.datvutech.mockito.dao.StudentDao;
import com.datvutech.mockito.model.Student;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public boolean save(Student student) {
        return studentDao.save(student);
    }
}
