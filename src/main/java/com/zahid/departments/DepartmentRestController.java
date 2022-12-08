package com.zahid.departments;

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
import org.springframework.web.servlet.ModelAndView;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService; // better idea

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        logger.info("New Department = {}", department);
        return departmentService.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getOneDepartment(@PathVariable("id") Long id) {
        logger.info("Department", departmentService.getDepartment(id));
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public List<Department> getAllDepartment() {
        logger.info("Departments:", departmentService.getAllDepartments());
        return departmentService.getAllDepartments();
    }

    @PostMapping("/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long id) {
        logger.info("Updated Department = {}", department);
        return departmentService.updateDepartment(department);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id) {
        logger.info("Department Id = {}", id);
        departmentService.deleteDepartment(id);

        return ResponseEntity.ok( "Department Deleted");
    }

}