package com.zahid.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.courses.Course;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        Student t = studentRepository.findById(student.getId()).get();
        t = student;
        studentRepository.save(t);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void enrollCourseToStudent(Course course) {
    }
}
