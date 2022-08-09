package com.data.jpa.springdatajpatutorial.entities;

import lombok.*;

import javax.persistence.*;

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
}
