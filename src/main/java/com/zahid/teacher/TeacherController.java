package com.zahid.teacher;

import com.zahid.courses.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService; // better idea

    @Autowired
    private CourseService courseService; // better idea

    @GetMapping
    public ModelAndView getAllTeacher() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("teacher-home");
        // ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("teachers", teacherService.getAllTeachers());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getOneTeacher(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("teacher-edit-form");

        modelAndView.addObject("teacher", teacherService.getTeacher(id));

        return modelAndView;
    }

    @GetMapping("/api/{id}")
    public Teacher getOneTeacherWithCourse(@PathVariable("id") Long id) {
        // ModelAndView modelAndView = new ModelAndView("teacher-edit-form");

        // modelAndView.addObject("teacher", teacherService.getTeacher(id));

        return teacherService.getTeacher(id);
    }

    @PostMapping("/{id}")
    public String updateTeacher(@ModelAttribute Teacher teacher, @PathVariable("id") Long id, Model model) {

        logger.info("New teacher = {}", teacher);

        teacherService.updateTeacher(teacher);

        return "teacher-edit-done";
    }

    @GetMapping("/add")
    public ModelAndView createTeacherForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("teacher-create-form");
        Teacher teacher = new Teacher();
        modelAndView.addObject("teacher", teacher);

        return modelAndView;
    }

    @PostMapping("/add")
    public String createTeacher(@ModelAttribute Teacher teacher) {

        logger.info("Teacher = {}", teacher);

        teacherService.addTeacher(teacher);

        return "teacher-create-done";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePrompt(@PathVariable("id") Long id) {
        logger.info("Teacher Id = {}", id);
        ModelAndView modelAndView = new ModelAndView("teacher-delete-confirm");
        modelAndView.addObject("teacher", teacherService.getTeacher(id));

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        logger.info("Teacher Id = {}", id);

        teacherService.deleteTeacher(id);

        return "teacher-delete-done";
    }


    @PutMapping("/api/{teacherId}/{courseId}")
    public Teacher enrollTeacherToCourse(

            @PathVariable("teacherId") Long teacherId,
            @PathVariable("courseId") Long courseId
    ) {
        return teacherService.enrollTeacherToCourse(teacherId, courseId);
    }

}