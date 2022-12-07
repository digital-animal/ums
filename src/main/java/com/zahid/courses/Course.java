package com.zahid.courses;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zahid.students.Student;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "course_hour", nullable = false)
    private String courseHour;

    // @JsonIgnore
    @ManyToMany
    private Set<Course> enrolledStudents = new HashSet<>();

    public Course(String courseTitle, String couseHour) {
        this.courseTitle = courseTitle;
        this.courseHour = couseHour;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", couseHour='" + courseHour + '\'' +
                '}';
    }

    public void enrollStudentToCourse(Student student) {
    }
}
