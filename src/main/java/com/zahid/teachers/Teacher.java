package com.zahid.teachers;

import com.zahid.courses.Course;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
public class Teacher {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "first_name", nullable = true)
    private String firstName;
    
    @Getter
    @Setter
    @Column(name = "last_name", nullable = true)
    private String lastName;
    
    @Getter
    @Setter
    @Column(name = "email", nullable = true)
    private String email;
    
    @Getter
    @Setter
    @Column(name = "date_of_birth", nullable = true)
    private String dateOfBirth;
    
    @Getter
    @Setter
    @Column(name = "address", nullable = true)
    private String address;
    
    @Getter
    @Setter
    @OneToMany(mappedBy = "courseTeacher")
    private Set<Course> courses = new HashSet<>();

    public Teacher(String firstName, String lastName, String email, String dateOfBirth, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }
}
