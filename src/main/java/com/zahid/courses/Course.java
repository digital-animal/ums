package com.zahid.courses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zahid.students.Student;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "course_hour", nullable = false)
    private String courseHour;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "courses"
    )
    // @ManyToMany(mappedBy = "courses")
    @JsonIgnore 
    private Set<Student> students = new HashSet<>();

    public Course(String courseTitle, String couseHour) {
        this.courseTitle = courseTitle;
        this.courseHour = couseHour;
    }
    
}
