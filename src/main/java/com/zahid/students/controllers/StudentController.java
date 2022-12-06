package com.zahid.students.controllers;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.students.models.Student;
import com.zahid.students.services.StudentService;

@Controller
// @RequestMapping("/students")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService; // better idea

    @GetMapping("/students")
    public ModelAndView getAllStudent() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        // ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("students", studentService.getAllStudents());

        return modelAndView;
    }

    @GetMapping("/students/{id}")
    public ModelAndView getOneStudent(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-form");

        modelAndView.addObject("student", studentService.getStudent(id));

        return modelAndView;
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@ModelAttribute Student student, @PathVariable("id") Long id, Model model) {

        logger.info("New student = {}", student);

        Student s = studentService.getStudent(id);

        studentService.updateStudent(s);

        return "edit-done";
    }

    @GetMapping("/students/add")
    public ModelAndView createStudentForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("create-form");
        Student student = new Student();
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping("/students/add")
    public String createStudent(@ModelAttribute Student student, Model model) {
        logger.info("Student = {}", student);

        studentService.addStudent(student);

        return "create-done";
    }

    @GetMapping("/students/delete/{id}")
    public ModelAndView deletePrompt(@PathVariable("id") Long id) {
        logger.info("Student Id = {}", id);
        ModelAndView modelAndView = new ModelAndView("delete-confirm");
        modelAndView.addObject("student", studentService.getStudent(id));

        return modelAndView;
    }

    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        logger.info("Student Id = {}", id);

        studentService.deleteStudent(id);

        return "redirect:/students/all";
    }

}