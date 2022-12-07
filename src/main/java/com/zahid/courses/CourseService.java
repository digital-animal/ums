package com.zahid.courses;

import java.util.List;

import com.zahid.students.Student;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);

    void enrollStudentToCourse(Student student);
}
