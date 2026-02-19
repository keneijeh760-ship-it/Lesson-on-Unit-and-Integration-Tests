package com.example.demo.Student;

import com.example.demo.student.Gender;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void itShouldCheckIfStudentExistsByEmail(){
        Student student = new Student(
                "Jemial",
                "jamila@email.com",
                Gender.FEMALE);
        studentRepository.save(student);

        boolean exist = studentRepository.selectExistsEmail(student.getEmail());


        assertThat(exist).isTrue();


    }
}
