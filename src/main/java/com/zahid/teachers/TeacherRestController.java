package com.zahid.teachers;

import com.zahid.courses.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService; // better idea

    @GetMapping
    public List<Teacher> getAllTeacher() {
        logger.info("Teachers:", teacherService.getAllTeachers());
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getOneTeacher(@PathVariable("id") Long id) {
        logger.info("Teacher", teacherService.getTeacher(id));
        return teacherService.getTeacher(id);
    }

    @PostMapping("/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id) {
        logger.info("Updated Teacher = {}", teacher);
        return teacherService.updateTeacher(teacher);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        logger.info("New Teacher = {}", teacher);
        teacherService.addTeacher(teacher);

        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id) {
        logger.info("Teacher Id = {}", id);
        teacherService.deleteTeacher(id);

        return ResponseEntity.ok("Teacher Deleted");
    }

}