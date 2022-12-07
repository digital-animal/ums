package com.zahid.courses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService=courseService;
    }

    @GetMapping("/courses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        System.out.println(courseService.getAllCourses());

        logger.info("courses", courseService);

        return "courses";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model) {

        // create course object to hold course form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-create";
    }

    @GetMapping("/api/courses/{id}")
    public Course getOneCourseWithStudent(@PathVariable("id") Long id) {

        return courseService.getCourseById(id);
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
        existingCourse.setCourseHour(course.getCourseHour());

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
