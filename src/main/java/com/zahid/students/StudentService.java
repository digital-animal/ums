package com.zahid.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private CourseService courseService;

    @Autowired
    private CourseService courseService;

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Student t = studentRepository.findById(student.getId()).get();
        t = student;
        return studentRepository.save(t);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student enrollStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseService.getCourseById(courseId);
        Set<Course> courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);

        return studentRepository.save(student);
    }
}
