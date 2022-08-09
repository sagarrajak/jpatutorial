package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
