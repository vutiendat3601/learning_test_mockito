package com.datvutech.mockito.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.datvutech.mockito.dao.EducationDao;
import com.datvutech.mockito.exception.NotAvailableException;
import com.datvutech.mockito.model.Student;

@ExtendWith(MockitoExtension.class)
public class EducationServiceTest {

    @InjectMocks
    private EducationService educationService;

    @Mock
    private EducationDao educationDao;

    @Test
    public void testAuthenticationSuccess() {
        Student student = new Student("vutiendat3601", "Dat Vu", "123456a@", "", false);
        Mockito.when(educationDao.authenticate(student.getUsername(), student.getPassword()))
                .thenReturn(true);
        Assertions.assertTrue(educationService.authenticate(student));
    }

    @Test
    public void testEnrollSuccess() {
        Student student = new Student("vutiendat3601", "Dat Vu", "123456a@", "", false);
        Mockito.doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            ((Student) args[0]).setEnrolled(true);
            return null;

        }).when(educationDao).updateStudent(student);
        Assertions.assertTrue(educationService.enroll(student));
        Mockito.verify(educationDao).updateStudent(student);
    }

    @Test
    public void testRetrieveTranscritpException() throws NotAvailableException {
        Student student = new Student("vutiendat3601", "Dat Vu", "123456a@", "", false);
        Mockito.doThrow(new NotAvailableException())
                .when(educationDao).getTranscript(student);
        Mockito.when(educationDao.isEnrolled(student)).thenReturn(true);
        Assertions.assertThrows(NotAvailableException.class,
                () -> educationService.retrieveTranscript(student));
    }

    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    public void testSpy() {
        // List<String> spyList = Mockito.spy(new ArrayList<>());
        spyList.add("Dat Vu");
        spyList.add("Ha Vy");
        spyList.add("Thanh Nhan");
        Mockito.verify(spyList).add("Dat Vu");
        Mockito.verify(spyList).add("Ha Vy");
        Assertions.assertEquals(3, spyList.size());
    }
}
