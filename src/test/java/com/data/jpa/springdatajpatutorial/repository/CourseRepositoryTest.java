package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Course;
import com.data.jpa.springdatajpatutorial.entities.Student;
import com.data.jpa.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("sdsdsd").lastName("scsdsds").build();
        Course course = Course.builder().teacher(teacher).title("saasas").credits(11).build();
        this.courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudent() {
        Teacher teacher = Teacher.builder().firstName("Teacher1").lastName("lastname").build();
        Course course = Course.builder().teacher(teacher).title("DSA").credits(6).build();
        Student student = Student.builder().firstName("sumit").lastName("kumar").email("sagarrajak858@gmail.com").build();
        course.addStudent(student);
        this.courseRepository.save(course);
    }

    @Test
    public void findAllWithPagination() {
        PageRequest firstPage = PageRequest.of(0, 2);
        PageRequest secondPage = PageRequest.of(1, 2);
        List<Course> firstPageCourseList = this.courseRepository.findAll(firstPage).getContent();
        List<Course> secondPageCourseList = this.courseRepository.findAll(secondPage).getContent();
        long totalElements = this.courseRepository.findAll(firstPage).getTotalElements();
        int totalPages = this.courseRepository.findAll(firstPage).getTotalPages();
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("secondPageCourseList = " + secondPageCourseList);
        System.out.println("firstPageCourseList = " + firstPageCourseList);
    }

    @Test
    public void findAllSorting() {
        PageRequest pageRequestSortByTitle = PageRequest.of(0, 2, Sort.by("title").descending());
        PageRequest pageRequestSortByCredits = PageRequest.of(1, 2, Sort.by("credits").descending());

        List<Course> content = this.courseRepository.findAll(pageRequestSortByTitle).getContent();
        List<Course> sortByCredits = this.courseRepository.findAll(pageRequestSortByCredits).getContent();
        System.out.println("sort by title = " + content);
        System.out.println("sort by credits = " + sortByCredits);
    }
}