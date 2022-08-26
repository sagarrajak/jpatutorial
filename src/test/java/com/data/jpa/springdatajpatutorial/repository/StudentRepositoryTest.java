package com.data.jpa.springdatajpatutorial.repository;

import com.data.jpa.springdatajpatutorial.entities.Course;
import com.data.jpa.springdatajpatutorial.entities.Guardian;
import com.data.jpa.springdatajpatutorial.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                            .firstName("sagar")
                            .lastName("rajak")
                            .email("sagarrajak859@gmail.com")
                .guardian(Guardian.builder().mobile("4343434").name("krishna").email("krishnarajak@gmail.com").build())
                .build();
        this.studentRepository.save(student);
    }

    @Test
    public void saveStudentWithCourse() {
        Student student = Student.builder()
                .firstName("some student")
                .lastName("second name")
                .email("sagarrajak89@gmail.com")
                .guardian(Guardian.builder().mobile("4343434").name("krishna").email("krishnarajak@gmail.com").build())
                .build();
        Course course = Course.builder().title("some course").credits(6).build();
        student.addCourse(course);
        this.studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = this.studentRepository.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = this.studentRepository.findByFirstName("sagar");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = this.studentRepository.findByFirstNameContaining("dada");
        System.out.println("students = " + students);
    }

    @Test
    public void printByLastNameNotNull() {
        List<Student> students = this.studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void printByGuardianName() {
        List<Student> students = this.studentRepository.findByGuardianName("krishna");
        System.out.println("students = " + students);
    }

    @Test
    public void printByStudentEmail() {
        Student student = this.studentRepository.getStudentByEmailAddress("sagarrajak858@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstName() {
        List<Student> student = this.studentRepository.getStudentByFirstName("sagar");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameNative() {
        List<Student> students = this.studentRepository.getStudentByFirstNameNative("sagar");
        System.out.println("students = " + students);
    }

    @Test
    public void updateFirstName() {
        int numberOfRowEffected = this.studentRepository.updateStudentNameByEmailId("sagarrajak858@gmail.com", "sagarr");
        System.out.println("numberOfRowEffected = " + numberOfRowEffected);
    }

}