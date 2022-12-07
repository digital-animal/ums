package com.zahid.students;

import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;

@Controller
// @RequestMapping("/students")
@RestController
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService; // better idea

    @Autowired
    private CourseService courseService; // better idea

    @GetMapping("/students")
    public ModelAndView getAllStudent() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("student-home");
        // ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("students", studentService.getAllStudents());

        return modelAndView;
    }

    @GetMapping("/students/{id}")
    public ModelAndView getOneStudent(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("student-edit-form");

        modelAndView.addObject("student", studentService.getStudent(id));

        return modelAndView;
    }

    // @GetMapping("/api/students/{id}")
    // public Student getOneStudentWithCourse(@PathVariable("id") Long id) {
    //     // ModelAndView modelAndView = new ModelAndView("student-edit-form");

    //     // modelAndView.addObject("student", studentService.getStudent(id));

    //     return studentService.getStudent(id);
    // }

    @GetMapping("/api/students/{id}")
    public Student getOneStudentWithCourse(@PathVariable("id") Long id) {
        // ModelAndView modelAndView = new ModelAndView("student-edit-form");

        // modelAndView.addObject("student", studentService.getStudent(id));

        return studentService.getStudent(id);
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@ModelAttribute Student student, @PathVariable("id") Long id, Model model) {

        logger.info("New student = {}", student);

        studentService.updateStudent(student);

        return "student-edit-done";
    }

    @GetMapping("/students/add")
    public ModelAndView createStudentForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("student-create-form");
        Student student = new Student();
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping("/students/add")
    public String createStudent(@ModelAttribute Student student) {

        logger.info("Student = {}", student);

        studentService.addStudent(student);

        return "student-create-done";
    }

    @GetMapping("/students/delete/{id}")
    public ModelAndView deletePrompt(@PathVariable("id") Long id) {
        logger.info("Student Id = {}", id);
        ModelAndView modelAndView = new ModelAndView("student-delete-confirm");
        modelAndView.addObject("student", studentService.getStudent(id));

        return modelAndView;
    }

    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        logger.info("Student Id = {}", id);

        studentService.deleteStudent(id);

        return "redirect:/students";
    }

    @PutMapping("/api/students/{studentId}/{courseId}")
    Student enrollStudentToCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId
    ) {
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudent(studentId);
        studentService.enrollStudentToCourse(student, course);
        
        return student;
    }

}