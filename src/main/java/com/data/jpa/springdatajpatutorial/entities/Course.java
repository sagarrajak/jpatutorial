package com.data.jpa.springdatajpatutorial.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence_generator",
            sequenceName = "course_sequence_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence_generator"
    )
    private Long courseId;
    private String title;
    private Integer credits;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id"
            )
    )
    List<Student> studentList;

    public void addStudent(Student student) {
        if (this.studentList == null) studentList = new ArrayList<>();
        this.studentList.add(student);
    }
}
