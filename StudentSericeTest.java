package com.example.demo.Student;

import com.example.demo.student.Gender;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentService studentService;
   ;
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {

        studentService = new StudentService(studentRepository);
    }



    @Test
    void cangetAllStudents() {

        studentService.getAllStudents();

        verify(studentRepository).findAll();
    }

    @Test
    @Disabled
    void canAddStudent() {
        Student student = new Student(
                "Jemial",
                "jamila@email.com",
                Gender.FEMALE);
        studentService.addStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository)
                .save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}
