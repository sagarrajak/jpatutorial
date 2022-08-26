package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Course;
import com.data.jpa.springdatajpatutorial.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder().title("some title").credits(100).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.course.com").course(course).build();
        this.courseMaterialRepository.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterials() {
           List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
           System.out.println("courseMaterialList = " + courseMaterialList);
    }
}