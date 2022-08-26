package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Course;
import com.data.jpa.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void  addTeacher() {
        Course course = Course.builder().title("sasasas").credits(6).build();

        Teacher teacher = Teacher.builder().firstName("sasa").lastName("sdsdsd").course(List.of(course)).build();
        teacherRepository.save(teacher);
    }

}