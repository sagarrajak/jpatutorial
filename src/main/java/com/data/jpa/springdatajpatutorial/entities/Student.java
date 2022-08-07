package com.data.jpa.springdatajpatutorial.entities;

import lombok.*;


import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    private Guardian guardian;
}
