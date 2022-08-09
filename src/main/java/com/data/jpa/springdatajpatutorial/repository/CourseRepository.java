package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
