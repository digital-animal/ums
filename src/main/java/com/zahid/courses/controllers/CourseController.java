package com.zahid.courses.controllers;

import com.zahid.courses.models.Course;
import com.zahid.courses.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService=courseService;
    }

    @GetMapping("/courses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        System.out.println(courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model) {

        // create course object to hold course form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-create";

    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "course-edit";
    }

    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable Long id,
                                @ModelAttribute("course") Course course,
                                Model model) {

        // get course from database by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setCourseTitle(course.getCourseTitle());
        existingCourse.setCourseTitle(course.getCourseHour());

        // save updated course object
        courseService.updateCourse(existingCourse);
        return "redirect:/courses";
    }

    // handler method to handle delete course request

    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}
