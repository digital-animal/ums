package com.zahid.courses.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "course_hour", nullable = false)
    private String courseHour;

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
}
