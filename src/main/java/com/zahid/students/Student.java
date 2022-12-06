package com.zahid.students;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.zahid.courses.models.Course;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "date_of_birth", nullable = true)
    private String dateOfBirth;
    
    @Column(name = "address", nullable = true)
    private String address;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(
    //     name = "student_course", 
    //     joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")},
    //     inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")}
    // )
    // private Set<Course> courseList = new HashSet<>();

    public Student(String firstName, String lastName, String email, String dateOfBirth, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

}
