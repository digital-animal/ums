package com.zahid.courses;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zahid.students.Student;
import com.zahid.teachers.Teacher;

@Entity
@Table(name = "courses")
@NoArgsConstructor
public class Course {
    @Id
    @Getter
    @Setter
    @Column(name = "course_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "course_title", nullable = false)
    private String courseTitle;
    
    @Getter
    @Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Teacher courseTeacher = null;

    public Course(String courseTitle, String couseHour) {
        this.courseTitle = courseTitle;
        this.courseHour = couseHour;
    }
    
    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public Teacher getCourseTeacher() {
        return this.courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}
