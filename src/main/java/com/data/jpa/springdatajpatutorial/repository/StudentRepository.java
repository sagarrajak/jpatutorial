package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String name);

    public List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("select s from Student s where s.firstName = ?1")
    List<Student> getStudentByFirstName(String name);

    @Query(value = "select * from student as s where s.first_name = ?1", nativeQuery = true)
    List<Student> getStudentByFirstNameNative(String name);

    @Transactional
    @Modifying
    @Query(
            value = "update student set first_name = ?2 where email = ?1",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String emailId, String name);


}
