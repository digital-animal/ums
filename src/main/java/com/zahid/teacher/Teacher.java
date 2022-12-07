package com.zahid.teacher;

import com.zahid.courses.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
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

    @OneToMany(mappedBy = "courseTeacher")
    private Set<Course> enrolledCourseList = new HashSet<>();

    public Teacher(String firstName, String lastName, String email, String dateOfBirth, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Set<Course> getEnrolledCourseList() {
        return this.enrolledCourseList;
    }
}
