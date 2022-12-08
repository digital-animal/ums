package com.zahid.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.teachers.Teacher;
import com.zahid.teachers.TeacherRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course assignCourseTeacher(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        course.setCourseTeacher(teacher);

        return courseRepository.save(course);
    }
}
