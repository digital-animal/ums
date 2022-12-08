package com.zahid.students;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService; // better idea

    @GetMapping
    public List<Student> getAllStudent() {
        logger.info("Students:", studentService.getAllStudents());
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable("id") Long id) {
        logger.info("Student", studentService.getStudent(id));
        return studentService.getStudent(id);
    }

    @PostMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        logger.info("Updated Student = {}", student);
        studentService.updateStudent(student);
        return studentService.updateStudent(student);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        logger.info("New Student = {}", student);
        studentService.addStudent(student);

        return studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        logger.info("Student Id = {}", id);
        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student Deleted");
    }

    @PutMapping("/{studentId}/{courseId}")
    public Student enrollStudentToCourse(

            @PathVariable("studentId") Long studentId,
            @PathVariable("courseId") Long courseId
    ) {
        return studentService.enrollStudentToCourse(studentId, courseId);
    }

}