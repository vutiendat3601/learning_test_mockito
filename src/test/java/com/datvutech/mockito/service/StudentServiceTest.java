package com.datvutech.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.datvutech.mockito.dao.StudentDao;
import com.datvutech.mockito.model.Student;

public class StudentServiceTest {

    @Test
    public void testSavingStudentSuccess() {
        StudentDao studentDao = Mockito.mock(StudentDao.class);
        StudentService studentService = new StudentService(studentDao);
        Student student = new Student("vutiendat3601", "Dat Vu", "123456a@", "", false);
        Mockito.when(studentDao.save(student)).thenReturn(true);

        Assertions.assertTrue(studentService.save(student));
    }

    @Test
    public void testSavingStudentFail() {
        StudentDao studentDao = Mockito.mock(StudentDao.class);
        StudentService studentService = new StudentService(studentDao);
        Student student = new Student("vutiendat3601", "Dat Vu", "123456a@", "", false);
        Mockito.when(studentDao.save(student)).thenReturn(false);

        Assertions.assertFalse(studentService.save(student));
    }
}
