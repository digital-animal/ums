package com.zahid.courses;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService; // better idea

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        logger.info("New Course = {}", course);
        return courseService.saveCourse(course);
    } 
    
    @GetMapping("/{id}")
    public Course getOneCourse(@PathVariable("id") Long id) {
        logger.info("Course", courseService.getCourseById(id));
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        logger.info("Courses:", courseService.getAllCourses());
        return courseService.getAllCourses();
    }

    @PostMapping("/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable("id") Long id) {
        logger.info("Updated Course = {}", course);
        return courseService.updateCourse(course);
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id) {
        logger.info("Course Id = {}", id);
        return ResponseEntity.ok("Course Deleted");
    }

    @PutMapping("/{courseId}/{teacherId}")
    public Course assignCourseToTeacher(

            @PathVariable("courseId") Long courseId,
            @PathVariable("teacherId") Long teacherId
    ) {

        return courseService.assignCourseTeacher(courseId, teacherId);
    }

}